package br.com.engsoftproj.datamenbers;

import br.com.engsoftproj.enumerators.NivelAcesso;

public class Usuario {
	private int ID;
	private String NOME;
	private String CARGO;       
	private String USERNAME;	 
	private String PASSWORD;   
	private NivelAcesso NIVEL_ACESSO;
	
	public Usuario(){
	
	}
	
	public int getId() {
		return ID;
	}

	public String getNome() {
		return NOME;
	}

	public String getCargo() {
		return CARGO;
	}

	public String getUsername() {
		return USERNAME;
	}

	public String getPassword() {
		return PASSWORD;
	}

	public NivelAcesso getNivelAcesso() {
		return NIVEL_ACESSO;
	}

	public void setId(int id) {
		ID = id;
	}

	public void setNome(String nome) {
		NOME = nome;
	}

	public void setCargo(String cargo) {
		CARGO = cargo;
	}

	public void setUsername(String username) {
		USERNAME = username;
	}

	public void setPassword(String password) {
		PASSWORD = password;
	}

	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		NIVEL_ACESSO = nivelAcesso;
	}
}
