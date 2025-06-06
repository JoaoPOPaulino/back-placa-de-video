package br.unitins.back.model.usuario;

import br.unitins.back.dto.request.usuario.TelefoneDTO;
import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity {

    @Column(name = "codigo_area")
    private String codigoArea;
    @Column(name = "numero")
    private String numero;

    public Telefone() {
    }

    public Telefone(TelefoneDTO dto) {
        this.codigoArea = dto.codigoArea();
        this.numero = dto.numero();
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone [codigoArea=" + codigoArea + ", numero=" + numero + "]";
    }

}
