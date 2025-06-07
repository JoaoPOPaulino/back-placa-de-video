package br.unitins.back.dto.request.pagamento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class PixDTO {

    @NotNull(message = "O ID do pedido é obrigatório.")
    private Long pedidoId;

    @NotNull(message = "O valor do pagamento é obrigatório.")
    private Integer valor;

    @NotNull(message = "O método de pagamento é obrigatório.")
    private String metodo;

    @Valid
    @NotNull(message = "Os dados do cliente são obrigatórios.")
    private CustomerDTO customer;

    // Getters e setters
    public Long getPedidoId() { return pedidoId; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

    public Integer getValor() { return valor; }
    public void setValor(Integer valor) { this.valor = valor; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public CustomerDTO getCustomer() { return customer; }
    public void setCustomer(CustomerDTO customer) { this.customer = customer; }
}
