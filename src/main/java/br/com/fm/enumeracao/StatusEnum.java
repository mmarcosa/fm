package br.com.fm.enumeracao;

public enum StatusEnum {
	
	BLOQUEADO("0","Bloqueado"),
	DESBLOQUEADO("1","Desbloqueado");
	
	private String codigo;
	
	private String descricao;
	
	private StatusEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static StatusEnum busca(String codigo) {
		for(StatusEnum se: StatusEnum.values()) {
			if(se.getCodigo().equals(codigo))
				return se;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return  "Enum : StatusEnum \n" +
				"Código : " + this.getCodigo() + " \n " +
				"Descrição : " + this.getDescricao();
	}

	
}
