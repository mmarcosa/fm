package br.com.fm.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.fm.log.Log;

@SuppressWarnings("serial")
@Interceptor
@Log
public class TempoDeExecucaoInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundInvoke
    public Object log(InvocationContext contexto) throws Exception {

        long inicio = System.currentTimeMillis();

        String metodo = contexto.getMethod().getName();

        Object proceder = contexto.proceed();

        long fim = System.currentTimeMillis();

        long resultado = fim - inicio;

        System.out.println("M�todo executado: " + metodo + " Tempo execu��o: " + resultado);

        return proceder;    
    }    
	
}
