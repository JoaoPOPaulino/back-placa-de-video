package br.unitins.back.model.estoque;

import java.time.LocalDateTime;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Estoque extends DefaultEntity {

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    private int quantidade;

    private LocalDateTime dataMovimentacao;
}
