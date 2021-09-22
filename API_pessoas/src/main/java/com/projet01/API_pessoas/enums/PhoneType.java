package com.projet01.API_pessoas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;




@Getter
@AllArgsConstructor
public enum PhoneType {

    CASA("casa"),
    COMERCIAL("comercial"),
    celular("celular");

    private final String descricao;


}
