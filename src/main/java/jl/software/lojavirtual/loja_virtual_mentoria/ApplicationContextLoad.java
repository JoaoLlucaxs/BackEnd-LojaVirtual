package jl.software.lojavirtual.loja_virtual_mentoria;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextLoad implements ApplicationContextAware{

	@Autowired
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	

}
