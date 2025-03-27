package br.unitins.back.model.placa_de_video;

import br.unitins.back.dto.request.placa_de_video.EspecificacaoTecnicaDTO;
import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class EspecificacaoTecnica extends DefaultEntity {

    @Column(nullable = false, length = 50)
    private String memoria;
    @Column(nullable = false, length = 50)
    private String clock;
    @Column(nullable = false, length = 50)
    private String barramento;
    @Column(nullable = false, length = 50)
    private String consumoEnergia;

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getBarramento() {
        return barramento;
    }

    public void setBarramento(String barramento) {
        this.barramento = barramento;
    }

    public String getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(String consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public void atualizarEspecificacao(EspecificacaoTecnicaDTO dto) {
        this.memoria = dto.memoria();
        this.clock = dto.clock();
        this.barramento = dto.barramento();
        this.consumoEnergia = dto.consumoEnergia();
    }

    public EspecificacaoTecnica(EspecificacaoTecnicaDTO dto) {
        this.memoria = dto.memoria();
        this.clock = dto.clock();
        this.barramento = dto.barramento();
        this.consumoEnergia = dto.consumoEnergia();
    }

    public EspecificacaoTecnica() {

    }

}
