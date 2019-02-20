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
	
	@AroundInvoke  //essa anota��o faz com que o CDI saiba o momento de executar 
	public Object  executaTX(InvocationContext contexto) throws Exception{
		manager.getTransaction().begin();
		
		Object resultado = contexto.proceed(); //isso se chama contexto de invoca��o, � poss�vel chamar o m�todo de uma maneira gen�rica
		
		manager.getTransaction().commit();
		
		return resultado;
	}
	
}
