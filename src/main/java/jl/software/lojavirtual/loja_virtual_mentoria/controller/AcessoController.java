package jl.software.lojavirtual.loja_virtual_mentoria.controller;

import jl.software.lojavirtual.loja_virtual_mentoria.model.Acesso;
import jl.software.lojavirtual.loja_virtual_mentoria.repository.AcessoRepository;
import jl.software.lojavirtual.loja_virtual_mentoria.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity <Acesso> salvarAcesso(@RequestBody Acesso acesso){ // request recebe json e converte em obj
        Acesso acessoSalvo=acessoService.save(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody // dar um retorno da api
    @PostMapping("**/deletarAcesso") // mapeando a url para receber um json
    public ResponseEntity<?> deletarAcesso(@RequestBody Acesso acesso){ // request recebe json e converte em obj
     acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
