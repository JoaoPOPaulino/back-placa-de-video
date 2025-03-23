package br.unitins.back.model.desconto;

public enum TipoDesconto {
    PERCENTUAL(1, "Percentual"), FIXO(2, "Fixo");

    private final Integer id;
    private final String label;

    TipoDesconto(Integer id, String label) {
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
