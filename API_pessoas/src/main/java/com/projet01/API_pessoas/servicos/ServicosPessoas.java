package com.projet01.API_pessoas.servicos;

import com.projet01.API_pessoas.dto.pedido.PessoasDTO;
import com.projet01.API_pessoas.dto.resposta.MensagemRespostaDTO;
import com.projet01.API_pessoas.entidade.Pessoas;
import com.projet01.API_pessoas.exceçoes.PessoasNaoEncontradasExcecoes;
import com.projet01.API_pessoas.mapear.MapperPessoas;
import com.projet01.API_pessoas.repositorio.RepositorioPessoas;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicosPessoas {


    private RepositorioPessoas repositorioPessoas;

    private final MapperPessoas mapperPessoas = MapperPessoas.INSTANCE;

    public MensagemRespostaDTO creatPessoas(PessoasDTO pessoasDTO){
        Pessoas pessoasToSave = mapperPessoas.toModel(pessoasDTO);

        Pessoas savedPessoas  = repositorioPessoas.save(pessoasToSave);
        return criarMensagemResposta(savedPessoas.getId(),"Criar uma pessoa com ID");

    }


    public List<PessoasDTO> listAll() {
        List<Pessoas> allpeople = repositorioPessoas.findAll();
        return allpeople.stream()
                .map(mapperPessoas::toDTO)
                .collect(Collectors.toList());
    }

    public PessoasDTO findById(Long id) throws PessoasNaoEncontradasExcecoes {
       Pessoas pessoas =verifyIfExists(id);

       return mapperPessoas.toDTO(pessoas);
    }

    public void delete(Long id) throws PessoasNaoEncontradasExcecoes{
        verifyIfExists(id);
        repositorioPessoas.deleteById(id);
    }

    public MensagemRespostaDTO updateById(Long id, PessoasDTO pessoasDTO) throws PessoasNaoEncontradasExcecoes{
       verifyIfExists(id);

       Pessoas pessoasToUpdate = mapperPessoas.toModel(pessoasDTO);

       Pessoas updatedPessoas = repositorioPessoas.save(pessoasToUpdate);
       return criarMensagemResposta(updatedPessoas.getId(),"Pessoa atualizada com ID");
    }
    private Pessoas verifyIfExists(Long id) throws PessoasNaoEncontradasExcecoes{
       return repositorioPessoas.findById(id)
               .orElseThrow(() -> new PessoasNaoEncontradasExcecoes(id));
    }

    private MensagemRespostaDTO criarMensagemResposta(Long id, String mensagem){
        return MensagemRespostaDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }


}
