package com.projet01.API_pessoas.numeros;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    CASA("casa"),
    celular("celular"),
    COMERCIAL("comercial");

    private final String descricao;



}
