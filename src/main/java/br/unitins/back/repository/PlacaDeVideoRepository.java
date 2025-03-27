package br.unitins.back.repository;

import java.util.List;

import br.unitins.back.model.placa_de_video.Categoria;
import br.unitins.back.model.placa_de_video.PlacaDeVideo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlacaDeVideoRepository implements PanacheRepository<PlacaDeVideo> {

    public long countByFabricante(Long idFabricante) {
        return count("fabricante.id", idFabricante);
    }

    public List<PlacaDeVideo> findByNome(String nome, int page, int pageSize) {
        return find("nome LIKE ?1", "%" + nome + "%")
                .page(page, pageSize)
                .list();
    }

    public List<PlacaDeVideo> findByCategoria(Categoria categoria) {
        return find("Categoria", categoria).list();
    }
}
