package br.unitins.back.model.avaliacao;

public enum Nota {
    UM("Pessimo", 1),
    DOIS("Ruim", 2),
    TRES("Bom", 3),
    QUATRO("Ótimo", 4),
    CINCO("Excelente", 5);

    private final String label;
    private final Integer id;

    Nota(String label, Integer id) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public Integer getId() {
        return id;
    }

    public static Nota valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (Nota nota : Nota.values()) {
            if (nota.getId().equals(id)) {
                return nota;
            }
        }
        throw new IllegalArgumentException("Nota inválida: " + id);
    }

}
