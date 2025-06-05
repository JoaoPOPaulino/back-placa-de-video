package br.unitins.back.model.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.unitins.back.model.DefaultEntity;
import br.unitins.back.model.pedido.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pagamento", discriminatorType = DiscriminatorType.STRING)
public abstract class Pagamento extends DefaultEntity {

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataPagamento;

    @Column(nullable = false)
    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @ManyToOne
    private Pedido pedido;

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

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
