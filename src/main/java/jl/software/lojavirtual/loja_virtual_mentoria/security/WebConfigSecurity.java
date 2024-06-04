package jl.software.lojavirtual.loja_virtual_mentoria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jl.software.lojavirtual.loja_virtual_mentoria.service.ImplementacaoUserDetailsService;

import javax.servlet.http.HttpSessionListener;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {

	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailService;
	
	// Irá consultar o usuário no banco com Spring Security
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(implementacaoUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET, "/salvarAcesso","/deletarAcesso")
                .antMatchers(HttpMethod.POST, "/salvarAcesso","/deletarAcesso"); // ignorando urls para não autenticar no momento
    }
}
