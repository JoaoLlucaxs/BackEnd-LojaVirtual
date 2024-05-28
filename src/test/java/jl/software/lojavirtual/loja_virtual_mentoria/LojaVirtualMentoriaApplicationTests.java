package jl.software.lojavirtual.loja_virtual_mentoria;

import jl.software.lojavirtual.loja_virtual_mentoria.controller.AcessoController;
import jl.software.lojavirtual.loja_virtual_mentoria.model.Acesso;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class LojaVirtualMentoriaApplicationTests  extends TestCase {

    @Autowired
    private AcessoController acessoController;
    @Test
    public void testCadastraAcesso() {
        Acesso acesso=new Acesso();
        acesso.setDescricao("ACESSO_TESTE");

        // NullPointer
      acesso= acessoController.salvarAcesso(acesso).getBody();

       assertEquals(true, acesso.getId() > 0);

      // assertEquals("ROLE_ADMIN",acesso.getDescricao());
    }

}
