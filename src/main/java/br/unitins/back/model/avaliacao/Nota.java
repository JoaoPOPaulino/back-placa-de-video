package br.unitins.back.model.avaliacao;

public enum Nota {
    UM("Pessimo", 1),
    DOIS("Ruim", 2),
    TRES("Bom", 3),
    QUATRO("Ótimo", 4),
    CINCO("Excelente", 5);

    private final String label;
    private final Integer valor;

    Nota(String label, Integer valor) {
        this.label = label;
        this.valor = valor;
    }

    public String getLabel() {
        return label;
    }

    public Integer getValor() {
        return valor;
    }

    public static Nota fromValor(Integer valor) {
        for (Nota nota : Nota.values()) {
            if (nota.getValor() == valor) {
                return nota;
            }
        }
        throw new IllegalArgumentException("Nota inválida: " + valor);
    }

}
