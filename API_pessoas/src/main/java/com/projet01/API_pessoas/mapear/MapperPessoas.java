package com.projet01.API_pessoas.mapear;

import com.projet01.API_pessoas.dto.pedido.PessoasDTO;
import com.projet01.API_pessoas.entidade.Pessoas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperPessoas {

    MapperPessoas INSTANCE = Mappers.getMapper(MapperPessoas.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyy")
     Pessoas toModel(PessoasDTO pessoasDTO);

     PessoasDTO toDTO(Pessoas pessoas);

}
