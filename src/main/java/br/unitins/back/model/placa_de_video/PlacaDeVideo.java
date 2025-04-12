package br.unitins.back.model.placa_de_video;

import java.math.BigDecimal;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class PlacaDeVideo extends DefaultEntity {

    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull(message = "O preço não pode ser nulo.")
    @Positive(message = "O preço deve ser positivo.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    private String nomeImagem;

    @NotNull(message = "A especificação técnica é obrigatória.")
    @ManyToOne
    @JoinColumn(name = "id_especificacao_tecnica", nullable = false)
    private EspecificacaoTecnica especificacaoTecnica;

    @NotNull(message = "O fabricante é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    private Fabricante fabricante;

    @NotNull(message = "A categoria é obrigatória.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Categoria categoria;

    @PositiveOrZero(message = "O estoque não pode ser negativo.")
    @Column(nullable = false)
    private Integer estoque = 0;

    // Construtores
    public PlacaDeVideo() {
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public EspecificacaoTecnica getEspecificacaoTecnica() {
        return especificacaoTecnica;
    }

    public void setEspecificacaoTecnica(EspecificacaoTecnica especificacaoTecnica) {
        this.especificacaoTecnica = especificacaoTecnica;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    // Métodos de negócio
    public void adicionarEstoque(Integer quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.estoque += quantidade;
    }

    public void removerEstoque(Integer quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        if (this.estoque < quantidade) {
            throw new IllegalStateException("Estoque insuficiente");
        }
        this.estoque -= quantidade;
    }
}
