package com.JoaoDev.ListaContados.Validacao;

import com.JoaoDev.ListaContados.Dominio.Contatos;
import com.JoaoDev.ListaContados.Repository.ContatosRepository;
import org.apache.commons.validator.routines.EmailValidator;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContatosValidacao extends ControllerException {
    final String nome="^[a-z A-Z ]+$";
    final String telefoneDDD="^[0-9]+$";
    Pattern validacaoNome=Pattern.compile(nome);
    Pattern validacaoTelefoneDDD= Pattern.compile(telefoneDDD);
    public ContatosValidacao() {
    }


    public Contatos idContato(ContatosRepository contatosRepository,Integer contatos){
        return  contatosRepository.findById(contatos).orElseThrow();
    }
    public  void validarSeContatoExiste(ContatosRepository contatosRepository,Contatos contatos){
        if(!contatosRepository.procuraContatoCadastradado(contatos.getEmail(), contatos.getNumero()).isEmpty()){
            throw new RuntimeException("JÁ POSSUI CONTATO COM ESSE TELEFONE OU EMAIL, PORFAVOR VERIFIQUE OS DADOS INFORMADOS");
        }
    }
    public void validarSeContatoAtualizadoJaExiste(ContatosRepository contatosRepository,Contatos contatos, Integer id){
        List<Contatos> contatosRepetidos = contatosRepository.procuraContatoCadastradado(contatos.getEmail(), contatos.getNumero());
        for (Contatos contato : contatosRepetidos) {
            if(contato.getId()!=id){
                throw new RuntimeException("EMAIL OU TELEFONE JÁ ESTÃO CADASTRADO");
            }
        }
    }
    public void validarCadastroContatos(Contatos contatos){

        Matcher nomeValidado=validacaoNome.matcher(contatos.getNome());
        Matcher DDDvalidado=validacaoTelefoneDDD.matcher(contatos.getDdd());
        Matcher telefoneValidado=validacaoTelefoneDDD.matcher(contatos.getNumero());

        //VALIDAÇÃO DO CAMPO NOME
        if(contatos.getNome() == null || contatos.getNome().isEmpty()){
            throw new RuntimeException("O Campo nome deve ser Preenchido, e não deve ser deixado em vazio");
        }if(!nomeValidado.find()){
            throw new RuntimeException("O nome tem Caracters Inválidos!");
        }else if(contatos.getNome().length() >= 30){
            throw new RuntimeException("Esse nome é muito extenso, digite um nome menor");
        }


        //VALIDAÇÃO DO CAMPO DDD
        if(contatos.getDdd() ==null || contatos.getDdd().isEmpty()){
            throw new RuntimeException("Por favor informe um DDD valído");
        }if(!DDDvalidado.find()){
            throw new RuntimeException("O Campo DDD contém caracter inválidos o campo só pode conter Números\"");
        } else if (contatos.getDdd().length() != 2 ) {
            throw new RuntimeException("O DDD deve  conter 2 Digitos");
        }

        //VALIDAÇÃO DO CAMPO TELEFONE
        if(contatos.getNumero()==null || contatos.getNumero().isEmpty()){
            throw new RuntimeException("O Campo Número deve ser Preenchido, e não deve ser deixado em vazio");
        }if(!telefoneValidado.find()){
            throw new RuntimeException("O Campo Número contém caracter inválidos o campo só pode conter Números");
        }else if(contatos.getNumero().length() !=9){
            throw new RuntimeException("O Campo Número deve conter 9 Digítios");
        }

        //VALIDAÇÃO DO CAMPO EMAIL
        if(!contatos.getEmail().isEmpty()){
           if(!EmailValidator.getInstance().isValid(contatos.getEmail())){
               throw new RuntimeException("O Email fornecido é inválido");
           }
        }

    }
}
