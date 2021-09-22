package com.projet01.API_pessoas.exceçoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoasNaoEncontradasExcecoes extends  Exception{

    public PessoasNaoEncontradasExcecoes(Long id){
        super("Pessoa não encontrada com ID" + id);
    }


}
