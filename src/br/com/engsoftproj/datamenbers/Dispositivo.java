package br.com.engsoftproj.datamenbers;

public class Dispositivo {	
	private int ID;
	private String NOME;
	private String CODIGO;       
	private String TIPO;
	
	public Dispositivo(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(String cODIGO) {
		CODIGO = cODIGO;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}	

}
