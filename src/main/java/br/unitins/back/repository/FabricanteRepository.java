package br.unitins.back.repository;

import br.unitins.back.model.placa_de_video.Fabricante;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FabricanteRepository implements PanacheRepository<Fabricante> {

    public PanacheQuery<Fabricante> findByNome(String nome) {
        return find("SELECT e FROM Fabricante e WHERE e.nome LIKE ?1 ", "%" + nome + "%");
    }

    public PanacheQuery<Fabricante> findAllOrdered() {
        return find("ORDER BY id ASC");
    }
}
