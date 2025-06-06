package br.unitins.back.model.desconto;

import java.math.BigDecimal;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cupom extends DefaultEntity {

    private String codigo;

    private BigDecimal valorDesconto;

    @Enumerated(EnumType.STRING)
    private TipoDesconto tipo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public TipoDesconto getTipo() {
        return tipo;
    }

    public void setTipo(TipoDesconto tipo) {
        this.tipo = tipo;
    }
}
