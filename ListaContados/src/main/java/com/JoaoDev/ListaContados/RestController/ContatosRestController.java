package com.JoaoDev.ListaContados.RestController;

import com.JoaoDev.ListaContados.DTO.ProcurarContato;
import com.JoaoDev.ListaContados.Dominio.Contatos;
import com.JoaoDev.ListaContados.Services.ContatosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContatosRestController {
    private final ContatosServices contatosServices;
    @Autowired
    public ContatosRestController(ContatosServices contatosServices) {
        this.contatosServices = contatosServices;
    }
    @PostMapping("/Cadastrar")
    public ResponseEntity salvar(@RequestBody Contatos contatos){
        this.contatosServices.cadastrar(contatos);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletarContato(@PathVariable Integer id){
        this.contatosServices.deletar(id);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/Procurar")
    public ResponseEntity procurarContato(@RequestBody ProcurarContato dto){
        return ResponseEntity.ok(this.contatosServices.ProcurarContato(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizarContato(@RequestBody Contatos contatos,@PathVariable Integer id){
        this.contatosServices.update(contatos,id);
        return ResponseEntity.ok().build();
    }
}
