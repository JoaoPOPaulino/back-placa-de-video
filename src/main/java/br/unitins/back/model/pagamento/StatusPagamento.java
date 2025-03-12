package br.unitins.back.model.pagamento;

public enum StatusPagamento {
    PENDENTE(1, "Pendente"),
    APROVADO(2, "Aprovado"),
    CANCELADO(3, "Cancelado"),
    FALHOU(4, "Falhou");

    private final Integer id;
    private final String label;

    private StatusPagamento(Integer id, String label) {
        this.id = null;
        this.label = null;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static StatusPagamento fromString(String status) {
        for (StatusPagamento tipo : StatusPagamento.values()) {
            if (tipo.name().equalsIgnoreCase(status)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Status do Pagamento inválido: " + status);
    }

}
