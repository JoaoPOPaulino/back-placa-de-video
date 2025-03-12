package br.unitins.back.model.pagamento;

public enum TipoCartao {
    CREDITO(1, "Crédito"),
    DEBITO(2, "Débito");

    private final Integer id;
    private final String label;

    TipoCartao(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoCartao fromString(String valor) {
        for (TipoCartao tipo : TipoCartao.values()) {
            if (tipo.name().equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("TipoCartao inválido: " + valor);
    }

}
