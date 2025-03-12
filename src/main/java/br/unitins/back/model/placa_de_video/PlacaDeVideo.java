package br.unitins.back.model.placa_de_video;

import java.math.BigDecimal;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PlacaDeVideo extends DefaultEntity {

    private String nome;
    private BigDecimal preco;
    private String nomeImagem;

    @OneToOne(cascade = CascadeType.ALL)
    private EspecificacaoTecnica especificacaoTecnica;

    @ManyToOne
    private Fabricante fabricante;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

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

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

}
