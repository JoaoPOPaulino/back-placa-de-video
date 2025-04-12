package br.unitins.back.repository;

import java.util.List;

import br.unitins.back.model.placa_de_video.EspecificacaoTecnica;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EspecificacaoTecnicaRepository implements PanacheRepository<EspecificacaoTecnica> {

    public List<EspecificacaoTecnica> findByMemoria(String memoria) {
        return find("memoria LIKE ?1", "%" + memoria + "%").list();
    }

    public PanacheQuery<EspecificacaoTecnica> findAllOrdered() {
        return find("ORDER BY id ASC");
    }
}
