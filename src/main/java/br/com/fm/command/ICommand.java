package br.com.fm.command;

import br.com.fm.model.EntidadeDominio;

public interface ICommand {
	
	void execute(EntidadeDominio entidadeDominio);
	
}
