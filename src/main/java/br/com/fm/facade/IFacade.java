package br.com.fm.facade;

import br.com.fm.model.EntidadeDominio;

public interface IFacade {

	void save(EntidadeDominio entidadeDominio);
	
	void update(EntidadeDominio entidadeDominio);
	
	void delete(EntidadeDominio entidadeDominio);
	
	void select(EntidadeDominio entidadeDominio);
	
}
