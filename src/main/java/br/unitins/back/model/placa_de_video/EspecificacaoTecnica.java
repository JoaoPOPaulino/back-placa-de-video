package br.unitins.back.model.placa_de_video;

import br.unitins.back.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class EspecificacaoTecnica extends DefaultEntity {

    private String memoria;
    private String clock;
    private String barramento;
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

}
