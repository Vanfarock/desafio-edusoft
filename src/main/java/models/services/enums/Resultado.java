package models.services.enums;

public enum Resultado {
	Sucesso("SUCESSO"),
	Erro("ERRO"),
	;

	private final String resultado;
	Resultado(String resultado) {
		this.resultado = resultado; 
	}
	
	@Override
	public String toString() {
		return resultado;
	}
}
