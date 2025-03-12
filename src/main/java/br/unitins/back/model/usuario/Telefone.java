package br.unitins.back.model.usuario;

import br.unitins.back.dto.request.usuario.TelefoneDTO;
import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Telefone extends DefaultEntity {

    @NotBlank
    @Size(min = 2, max = 2)
    @Column(length = 2, nullable = false)
    private String codigoArea;
    @NotBlank
    @Size(min = 8, max = 12)
    @Column(length = 12, nullable = false)
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
