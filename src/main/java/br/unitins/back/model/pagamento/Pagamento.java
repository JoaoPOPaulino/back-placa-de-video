package br.unitins.back.model.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrePersist;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pagamento", discriminatorType = DiscriminatorType.STRING)
public abstract class Pagamento extends DefaultEntity {

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataPagamento;

    @Column(nullable = false)
    private BigDecimal valorPago;

    @PrePersist
    protected void onCreate() {
        if (this.dataPagamento == null) {
            this.dataPagamento = LocalDateTime.now();
        }
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

}
