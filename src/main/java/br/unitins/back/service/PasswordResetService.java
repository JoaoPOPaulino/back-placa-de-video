package br.unitins.back.service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import br.unitins.back.model.usuario.Usuario;
import br.unitins.back.repository.UsuarioRepository;
import br.unitins.back.service.email.EmailService;

@ApplicationScoped
public class PasswordResetService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    EmailService emailService;

    // Map simula cache (em produção use Redis ou banco)
    private static class TokenData {
        String email;
        LocalDateTime expiration;
    }

    private final ConcurrentHashMap<String, TokenData> tokenStore = new ConcurrentHashMap<>();

    public void requestPasswordReset(String loginOrEmail) {
        Usuario usuario = usuarioRepository.findByLogin(loginOrEmail);
        if (usuario == null) {
            usuario = usuarioRepository.findByEmail(loginOrEmail);
        }

        if (usuario == null) {
            // Silenciosamente falha para evitar vazamento de existência
            return;
        }

        String token = UUID.randomUUID().toString();
        TokenData data = new TokenData();
        data.email = usuario.getEmail();
        data.expiration = LocalDateTime.now().plusMinutes(30);

        tokenStore.put(token, data);

        String resetLink = "http://localhost:4200/resetar-senha?token=" + token;
        String msg = "Olá, " + usuario.getNome() + ". Clique para redefinir sua senha: " + resetLink;

        emailService.sendEmail(usuario.getEmail(), "Recuperação de Senha", msg);
    }

    public String getEmailFromToken(String token) {
        TokenData data = tokenStore.get(token);
        if (data == null || data.expiration.isBefore(LocalDateTime.now())) {
            return null;
        }
        return data.email;
    }

    public void invalidateToken(String token) {
        tokenStore.remove(token);
    }
}
