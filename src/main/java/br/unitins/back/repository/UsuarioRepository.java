package br.unitins.back.repository;

import java.util.List;
import java.util.Optional;

import br.unitins.back.model.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }

    public Optional<Usuario> findByLogin(String login) {
        return find("login", login).firstResultOptional();
    }

    public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
        return find("login = ?1 AND senha = ?2", login, senha).firstResultOptional();
    }
}
