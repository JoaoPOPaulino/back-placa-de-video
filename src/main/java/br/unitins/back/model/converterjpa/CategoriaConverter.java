package br.unitins.back.model.converterjpa;

import br.unitins.back.model.placa_de_video.Categoria;
import jakarta.persistence.AttributeConverter;

public class CategoriaConverter implements AttributeConverter<Categoria, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Categoria categoria) {
        return (categoria == null ? null : categoria.getId());
    }

    @Override
    public Categoria convertToEntityAttribute(Integer id) {
        return Categoria.valueOf(id);
    }

}
