package br.com.engsoftproj.enumerators;

public enum NivelAcesso {
	ROOT(0), 	GERENTE(1), 	TECNICO(2);
	private int value;

	private NivelAcesso(int value) {
            this.value = value;
    }
}
