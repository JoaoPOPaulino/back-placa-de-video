package br.unitins.back.model.converterjpa;


import br.unitins.back.model.avaliacao.Nota;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NotaConverter implements AttributeConverter<Nota, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Nota nota) {
        return (nota == null ? null : nota.getId());
    }

    @Override
    public Nota convertToEntityAttribute(Integer id) {
        return Nota.valueOf(id);
    }
} 
