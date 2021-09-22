package com.projet01.API_pessoas.controlador;

import com.projet01.API_pessoas.dto.pedido.PessoasDTO;
import com.projet01.API_pessoas.dto.resposta.MensagemRespostaDTO;
import com.projet01.API_pessoas.exceçoes.PessoasNaoEncontradasExcecoes;
import com.projet01.API_pessoas.servicos.ServicosPessoas;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControladorPessoas {

    private ServicosPessoas servicosPessoas;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO creatPessoas(@RequestBody @Valid PessoasDTO pessoasDTO){
        return servicosPessoas.creatPessoas(pessoasDTO);
    }

    @GetMapping
    public List<PessoasDTO> listAll(){

        return servicosPessoas.listAll();
    }

    @GetMapping("/{id}")
    public PessoasDTO findById(@PathVariable Long id) throws PessoasNaoEncontradasExcecoes {
        return servicosPessoas.findById(id);
    }

    @PutMapping("/{id}")
    public MensagemRespostaDTO updateById(@PathVariable Long id, @RequestBody @Valid PessoasDTO pessoasDTO) throws  PessoasNaoEncontradasExcecoes{
       return servicosPessoas.updateById(id, pessoasDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PessoasNaoEncontradasExcecoes{
        servicosPessoas.delete(id);
    }


}
