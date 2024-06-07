package jl.software.lojavirtual.loja_virtual_mentoria.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// Criar autenticação e retornar autenticação JWT
@Component
@Service
public class JWTTokenAutenticacaoService {

	// Token validade 11 dias
	private static final long EXPIRATION_TIME=959990000;
	
	// Chave de senha para juntar com JWT
	private static final String SECRET="ss/-*-*sds565dsd-s/d-s*dsds";
	
	private static final String TOKEN_PREFIX="Bearer";
	
	private static final String HEADER_TOKEN="Authorization";
	
	// Gerar o token e dar resposta para o cliente
	public void addAuthentication(HttpServletResponse response, String username) throws Exception{
			//montagem do token
		
		String JWT=Jwts.builder() // chama o gerador de token
				.setSubject(username)// adiciona o user
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact(); // Tempo de expiração
		
		String token=TOKEN_PREFIX + " " + JWT;
		
		// Da resposta para a tela e para o cliente ... outra api , navegador , aplicativo , javascript ou até outra chamada Java
		response.addHeader(HEADER_TOKEN, token);
		
		// Usado para ver no Postman para teste
		response.getWriter().write("{\"Authorization\":\"" + token + "\"}");
	}
}
