package br.unitins.back.model.placa_de_video;

import br.unitins.back.dto.request.placa_de_video.FabricanteDTO;
import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Fabricante extends DefaultEntity {

    @Column(nullable = false, unique = true)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void atualizarFabricante(FabricanteDTO dto) {
        this.nome = dto.nome();
    }

    public Fabricante() {

    }

    public Fabricante(FabricanteDTO dto) {
        this.nome = dto.nome();
    }

}
