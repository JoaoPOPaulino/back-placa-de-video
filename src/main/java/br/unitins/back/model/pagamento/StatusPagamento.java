package br.unitins.back.model.pagamento;

public enum StatusPagamento {
    PENDENTE(1, "Pendente"),
    APROVADO(2, "Aprovado"),
    CANCELADO(3, "Cancelado"),
    FALHOU(4, "Falhou");

    private final Integer id;
    private final String label;

    private StatusPagamento(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static StatusPagamento valueOf(Integer id) throws IllegalArgumentException {
        if ((id == null)) {
            return null;
        }
        for (StatusPagamento statusPagamento : StatusPagamento.values()) {
            if (statusPagamento.getId().equals(id)) {
                return statusPagamento;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }

}
