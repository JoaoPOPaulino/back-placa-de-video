package br.unitins.back.model.usuario;

import br.unitins.back.dto.request.usuario.EnderecoDTO;
import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Endereco extends DefaultEntity {

    private String cep;
    private String estado;
    private String cidade;
    private String quadra;
    private String rua;
    private Integer numero;

    public Endereco() {

    }

    public Endereco(EnderecoDTO dto) {
        this.cep = dto.cep();
        this.estado = dto.estado();
        this.cidade = dto.cidade();
        this.quadra = dto.quadra();
        this.rua = dto.rua();
        this.numero = dto.numero();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco [cep=" + cep + ", estado=" + estado + ", cidade=" + cidade
                + ", quadra=" + quadra + ", rua=" + rua + ", numero=" + numero + "]";
    }
}
