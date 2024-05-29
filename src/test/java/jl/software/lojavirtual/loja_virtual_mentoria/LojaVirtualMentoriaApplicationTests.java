package jl.software.lojavirtual.loja_virtual_mentoria;

import jl.software.lojavirtual.loja_virtual_mentoria.controller.AcessoController;
import jl.software.lojavirtual.loja_virtual_mentoria.model.Acesso;
import jl.software.lojavirtual.loja_virtual_mentoria.repository.AcessoRepository;
import junit.framework.TestCase;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class LojaVirtualMentoriaApplicationTests  extends TestCase {

    @Autowired
    private AcessoController acessoController;
    
    @Autowired
    private AcessoRepository acessoRepository;
    
    @Test
    public void testCadastraAcesso() {
        Acesso acesso=new Acesso();
        acesso.setDescricao("ACESSO_TESTE");

       assertEquals(true, acesso.getId() == null);
      
       // Gravou no banco
      acesso= acessoController.salvarAcesso(acesso).getBody();

       assertEquals(true, acesso.getId() > 0);

       // validando dados salvos da forma correta
       assertEquals("ACESSO_TESTE",acesso.getDescricao());
       
       // Validar carregamento
       Acesso acesso2=acessoRepository.findById(acesso.getId()).get();
       
       assertEquals(acesso.getId(), acesso2.getId());
       
       // teste delete
       acessoRepository.deleteById(acesso2.getId());
       acessoRepository.flush(); // rodar esse sql de delete no banco de dados
       
       Acesso acesso3=acessoRepository.findById(acesso2.getId()).orElse(null);
       assertEquals(true, acesso3 == null);
       
       // teste de query
       acesso=new Acesso();
       acesso.setDescricao("ACESSO_ALUNO");
       
       acesso=acessoController.salvarAcesso(acesso).getBody();
       List<Acesso> acessos=acessoRepository.buscarAcesso("ALUNO".trim().toUpperCase());
       assertEquals(1, acessos.size());
       
       acessoRepository.deleteById(acesso.getId());
    }

}
