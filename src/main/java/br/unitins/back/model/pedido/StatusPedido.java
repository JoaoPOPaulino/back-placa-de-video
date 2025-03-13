package br.unitins.back.model.pedido;

public enum StatusPedido {
    AGUARDANDO_PAGAMENTO(1, "Aguardando Pagamento"),
    PAGO(2, "Pago"),
    ENVIADO(3, "Enviado"),
    ENTREGUE(4, "Entregue"),
    CANCELADO(5, "Cancelado");

    private final Integer id;
    private final String label;

    StatusPedido(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static StatusPedido fromString(String status) {
        for (StatusPedido tipo : StatusPedido.values()) {
            if (tipo.name().equalsIgnoreCase(status)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Status do Pedido: " + status);
    }
}
