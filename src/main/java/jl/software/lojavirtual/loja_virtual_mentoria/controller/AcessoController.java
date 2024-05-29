package jl.software.lojavirtual.loja_virtual_mentoria.controller;

import jl.software.lojavirtual.loja_virtual_mentoria.model.Acesso;
import jl.software.lojavirtual.loja_virtual_mentoria.repository.AcessoRepository;
import jl.software.lojavirtual.loja_virtual_mentoria.service.AcessoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @Autowired
    private AcessoRepository acessoRepository;

    @ResponseBody // dar um retorno da api
    @PostMapping("**/salvarAcesso") // mapeando a url para receber um json
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso){ // request recebe json e converte em obj
        Acesso acessoSalvo=acessoService.save(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody 
    @PostMapping("**/deletarAcesso") 
    public ResponseEntity<?> deletarAcesso(@RequestBody Acesso acesso){ 
     acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity("Acesso removido",HttpStatus.OK);
    }
    
    @ResponseBody
    @DeleteMapping("**/deletarAcessoPorId/{id}") 
    public ResponseEntity<?> deletarAcessoPorId(@PathVariable("id") Long id){
     acessoRepository.deleteById(id);
        return new ResponseEntity("Acesso por id removido",HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping("**/obterAcesso/{id}") 
    public ResponseEntity<Acesso> obterAcesso(@PathVariable("id") Long id){ 
    	Acesso acesso=	acessoRepository.findById(id).get();
    	
        return new ResponseEntity<Acesso>(acesso,HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping("**/buscarPorDesc/{desc}") 
    public ResponseEntity<List<Acesso>> obterAcesso(@PathVariable("desc") String desc){ 
    	List<Acesso> acesso=acessoRepository.buscarAcesso(desc);
    	
        return new ResponseEntity<List<Acesso>>(acesso,HttpStatus.OK);
    }
}
