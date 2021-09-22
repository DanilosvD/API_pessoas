package com.projet01.API_pessoas.dto.pedido;

import com.projet01.API_pessoas.entidade.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PessoasDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String  primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String segundoNome ;

    @NotEmpty
    @CPF
    private String cpf;

    private LocalDate dataNascimento;
    @Valid
    @NotEmpty
    private List<Telefone> telefone;
}
