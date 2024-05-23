package jl.software.lojavirtual.loja_virtual_mentoria;

import jl.software.lojavirtual.loja_virtual_mentoria.controller.AcessoController;
import jl.software.lojavirtual.loja_virtual_mentoria.model.Acesso;
import jl.software.lojavirtual.loja_virtual_mentoria.repository.AcessoRepository;
import jl.software.lojavirtual.loja_virtual_mentoria.service.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class LojaVirtualMentoriaApplicationTests  extends TestCase {

    @Autowired
    private AcessoService acessoService;

    //@Autowired
    //private AcessoRepository acessoRepository;

    @Autowired
    private AcessoController acessoController;
    @Test
    public void testCadastraAcesso() {
        Acesso acesso=new Acesso();
        //acesso.setDescricao("ROLE_ADMIN");

       //acesso= acessoController.salvarAcesso(acesso).getBody();

       //assertEquals(true, acesso.getId() > 0);

      // assertEquals("ROLE_ADMIN",acesso.getDescricao());
    }

}
