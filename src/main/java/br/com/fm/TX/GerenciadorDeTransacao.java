package br.com.fm.TX;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;
	
	@AroundInvoke  //essa anotação faz com que o CDI saiba o momento de executar 
	public Object  executaTX(InvocationContext contexto) throws Exception{
		manager.getTransaction().begin();
		
		Object resultado = contexto.proceed(); //isso se chama contexto de invocação, é possível chamar o método de uma maneira genérica
		
		manager.getTransaction().commit();
		
		return resultado;
	}
	
}
