package br.unitins.back.model.placa_de_video;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Fabricante extends DefaultEntity {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
