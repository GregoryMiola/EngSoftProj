package br.com.engsoftproj.enumerators;

public enum StatusMudanca {
	PENDENTE(0), APROVADA(1), REPROVADA(2);
	private int value;
	
	private StatusMudanca(int v){
		this.value = v;
	}
}
