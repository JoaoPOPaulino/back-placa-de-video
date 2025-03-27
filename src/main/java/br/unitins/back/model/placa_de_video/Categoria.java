package br.unitins.back.model.placa_de_video;

public enum Categoria {
    ENTRADA(1, "Entrada"),
    INTERMEDIARIA(2, "Intermediária"),
    ALTO_DESEMPENHO(3, "Alto Desempenho");

    private final Integer id;
    private final String label;

    Categoria(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Categoria valueOf(Integer id) throws IllegalArgumentException {
        if ((id == null)) {
            return null;
        }
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getId().equals(id)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
