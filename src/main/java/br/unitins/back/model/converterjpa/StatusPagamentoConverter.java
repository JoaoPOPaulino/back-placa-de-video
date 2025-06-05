package br.unitins.back.model.converterjpa;
import br.unitins.back.model.pagamento.StatusPagamento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusPagamentoConverter implements AttributeConverter<StatusPagamento, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusPagamento statuspagamento) {
        return (statuspagamento == null ? null : statuspagamento.getId());
    }

    @Override
    public StatusPagamento convertToEntityAttribute(Integer id) {
        return StatusPagamento.valueOf(id);
    }
}