package br.unitins.back.repository;

import java.util.List;

import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlacaDeVideoRepository implements PanacheRepository<PlacaDeVideo> {

    public long countByFabricante(Long idFabricante) {
        return count("fabricante.id", idFabricante);
    }

    public List<PlacaDeVideo> findByNome(String nome, int page, int pageSize) {
        PanacheQuery<PlacaDeVideo> query;
        if (nome == null || nome.trim().isEmpty()) {
            query = findAllOrdered();
        } else {
            query = find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%");
        }
        return query.page(page, pageSize).list();
    }

    public List<PlacaDeVideo> findByCategoria(Categoria categoria) {
        return find("Categoria", categoria).list();
    }

    public PanacheQuery<PlacaDeVideo> findAllOrdered() {
        return find("ORDER BY nome ASC");
    }

    public long countByNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return count();
        }
        return count("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%");
    }
}
