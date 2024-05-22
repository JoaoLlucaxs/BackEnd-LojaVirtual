package jl.software.lojavirtual.loja_virtual_mentoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "jl.software.lojavirtual.loja_virtual_mentoria.model") // scanear onde está os models
@ComponentScan(basePackages = {"jl.*"}) // varrendo projeto procurando por anotações e recursos com spring boot
@EnableJpaRepositories(basePackages = {"jl.software.lojavirtual.loja_virtual_mentoria.repository"})
@EnableTransactionManagement //gerenciar minhas transações com o banco de dados
public class LojaVirtualMentoriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
    }

}
