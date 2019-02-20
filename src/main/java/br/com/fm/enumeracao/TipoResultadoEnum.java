package br.com.fm.enumeracao;

public enum TipoResultadoEnum {
	
	EMPATE("E","Empate"),
	VITORIA("V","Vitória"),
	DERROTA("D", "Derrota");
	
	private String codigo;
	private String descricao;
	
	private TipoResultadoEnum(String codigo, String descricao) {
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

	public static TipoResultadoEnum busca(String codigo) {
		for(TipoResultadoEnum tre: TipoResultadoEnum.values()) {
			if(tre.getCodigo().equals(codigo))
				return tre;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return  "Enum : TipoResultadoEnum \n" +
				"Código : " + this.getCodigo() + " \n " +
				"Descrição : " + this.getDescricao();
	}
	
}
