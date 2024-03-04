package com.JoaoDev.ListaContados.Services;

import com.JoaoDev.ListaContados.DTO.ProcurarContato;
import com.JoaoDev.ListaContados.Dominio.Contatos;
import com.JoaoDev.ListaContados.Repository.ContatosRepository;
import com.JoaoDev.ListaContados.Validacao.ContatosValidacao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosServices {
    private final ContatosRepository contatosRepository;
    ContatosValidacao contatosValidacao=new ContatosValidacao();
    @Autowired
    public ContatosServices(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;

    }


    @Transactional
    public Contatos cadastrar(Contatos contatos){
        this.contatosValidacao.validarCadastroContatos(contatos);
        this.contatosValidacao.validarSeContatoExiste(contatosRepository,contatos);
        return this.contatosRepository.save(contatos);
    }
    @Transactional
    public void deletar(Integer id){
        this.contatosValidacao.idContato(contatosRepository,id);
        this.contatosRepository.deleteById(id);
    }
    @Transactional
    public List<Contatos> ProcurarContato(ProcurarContato dto) {
        return this.contatosRepository.procurarContatoInformacao(dto.getProcurar());
    }
    @Transactional
    public Contatos update(Contatos contatos,Integer id){
        Optional<Contatos> optContato = contatosRepository.findById(id);
        if(optContato.isPresent()){
            Contatos updateContado=optContato.get();
            updateContado.setNome(contatos.getNome());
            updateContado.setDdd(contatos.getDdd());
            updateContado.setNumero(contatos.getNumero());
            updateContado.setEmail(contatos.getEmail());
            this.contatosValidacao.validarSeContatoAtualizadoJaExiste(contatosRepository,updateContado,id);
            this.contatosValidacao.validarCadastroContatos(updateContado);
            return this.contatosRepository.save(updateContado);
        }else{
            throw new RuntimeException("Não salvo!!");
        }
    }



}
