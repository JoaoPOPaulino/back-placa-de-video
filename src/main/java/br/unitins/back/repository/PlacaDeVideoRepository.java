package br.unitins.back.repository;

import java.util.List;
import java.util.Optional;

import br.unitins.back.model.placa_de_video.PlacaDeVideo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlacaDeVideoRepository implements PanacheRepository<PlacaDeVideo> {

    public List<PlacaDeVideo> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }

    public Optional<PlacaDeVideo> findByMarca(String marca) {
        return find("UPPER(marca) LIKE UPPER(?1)", "%" + marca + "%").firstResultOptional();
    }
}
