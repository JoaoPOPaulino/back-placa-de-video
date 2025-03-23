package br.unitins.back.model.estoque;

public enum TipoMovimentacao {
    ENTRADA(1, "Entrada"), SAIDA(2, "Saída");

    private final Integer id;
    private final String label;

    TipoMovimentacao(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

}
