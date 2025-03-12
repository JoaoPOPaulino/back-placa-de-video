package br.unitins.back.repository;

import java.util.List;

import br.unitins.back.model.pagamento.Pagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento> {

    public List<Pagamento> findByUsuario(Long idUsuario) {
        return find("usuario.id = ?1", idUsuario).list();
    }

    public List<Pagamento> findByStatus(String status) {
        return find("status = ?1", status).list();
    }
}
