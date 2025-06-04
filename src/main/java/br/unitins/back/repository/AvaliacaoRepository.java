package br.unitins.back.repository;

import java.util.List;

import br.unitins.back.model.avaliacao.Avaliacao;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvaliacaoRepository implements PanacheRepository<Avaliacao> {

    public List<Avaliacao> findByUsuario(Long idUsuario) {
        return find("usuario.id = ?1", idUsuario).list();
    }

    public List<Avaliacao> findByPlacaDeVideo(Long idPlacaDeVideo) {
        return find("placaDeVideo.id = ?1", idPlacaDeVideo).list();
    }

    public PanacheQuery<Avaliacao> findAllOrdered() {
        return find("ORDER BY dataCriacao ASC");
    }
}
