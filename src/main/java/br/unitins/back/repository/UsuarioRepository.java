package br.unitins.back.repository;

import java.util.List;

import br.unitins.back.model.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

    public Usuario findByLogin(String login) {
        return find("login", login).firstResult();
    }

    public boolean existsByLogin(String login) {
        return count("login = ?1", login) > 0;
    }

    public boolean existsByEmail(String email) {
        return count("email = ?1", email) > 0;
    }

    public Usuario findByLoginAndSenha(String login, String senha) {
        try {
            return find("login = ?1 AND senha = ?2 ", login, senha).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
