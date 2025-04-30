package br.unitins.back.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

import org.jboss.logging.Logger;

import br.unitins.back.model.PasswordResetToken;
import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.PasswordResetTokenRepository;
import br.unitins.back.repository.UsuarioRepository;
import br.unitins.back.service.hash.HashService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

@ApplicationScoped
public class PasswordResetService {
    private static final Logger LOGGER = Logger.getLogger(PasswordResetService.class);

    @Inject
    Mailer mailer;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PasswordResetTokenRepository tokenRepository;

    @Inject
    HashService hashService;

    @Transactional
    public void requestPasswordReset(String loginOrEmail) {
        LOGGER.infof("Iniciando solicitação de recuperação de senha para: %s", loginOrEmail);

        // Buscar usuário por login ou e-mail
        Usuario usuario = usuarioRepository.findByLoginOrEmail(loginOrEmail);
        if (usuario == null) {
            LOGGER.warnf("Usuário não encontrado para login ou e-mail: %s", loginOrEmail);
            throw new NotFoundException("Usuário não encontrado");
        }

        // Gerar token seguro
        String token = generateSecureToken();
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(24); // Token válido por 24 horas

        // Salvar token no banco
        PasswordResetToken resetToken = new PasswordResetToken(token, usuario, expiryDate);
        tokenRepository.persist(resetToken);

        // Criar link de recuperação
        String resetLink = "http://localhost:4200/reset-password?token=" + token; // Ajuste a URL para produção
        String emailBody = String.format(
                "<h1>Recuperação de Senha</h1>" +
                "<p>Olá %s,</p>" +
                "<p>Clique no link abaixo para redefinir sua senha:</p>" +
                "<a href=\"%s\">Redefinir Senha</a>" +
                "<p>Este link expira em 24 horas. Se você não solicitou esta recuperação, ignore este e-mail.</p>" +
                "<p>Atenciosamente,<br>Equipe Placa de Vídeo</p>",
                usuario.getNome(), resetLink
        );

        // Enviar e-mail
        try {
            mailer.send(Mail.withHtml(usuario.getEmail(), "Recuperação de Senha", emailBody));
            LOGGER.infof("E-mail de recuperação enviado para: %s", usuario.getEmail());
        } catch (Exception e) {
            LOGGER.errorf("Erro ao enviar e-mail de recuperação para: %s", usuario.getEmail(), e);
            throw new RuntimeException("Erro ao enviar e-mail de recuperação", e);
        }
    }

    @Transactional
    public void resetPassword(String token, String newPassword) {
        LOGGER.info("Iniciando redefinição de senha com token");

        // Buscar token
        PasswordResetToken resetToken = tokenRepository.findByToken(token);
        if (resetToken == null || resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            LOGGER.warn("Token inválido ou expirado: " + token);
            throw new RuntimeException("Token inválido ou expirado");
        }

        // Atualizar senha do usuário
        Usuario usuario = resetToken.getUsuario();
        usuario.setSenha(hashService.getHashSenha(newPassword));
        usuarioRepository.persist(usuario);

        // Invalidar o token
        tokenRepository.delete(resetToken);
        LOGGER.infof("Senha redefinida com sucesso para usuário: %s", usuario.getEmail());
    }

    private String generateSecureToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32]; // 256 bits
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}
