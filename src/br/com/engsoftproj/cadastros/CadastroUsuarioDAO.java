package br.com.engsoftproj.cadastros;

import br.com.engsoftproj.datamenbers.Usuario;
import br.com.engsoftproj.db.SQLiteJDBC;


public class CadastroUsuarioDAO {	
	
	protected static void salvaUsuario(Usuario novo){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO USUARIOS (NOME, CARGO, USERNAME, PASSWORD, NIVEL_ACESSO) ");
		sql.append("VALUES ('" + novo.getNome() + "', '" + novo.getCargo() + "', '" + novo.getUsername() + "', '" + novo.getPassword() + "', '" + novo.getNivelAcesso().getValue() + "') "); 
		
		SQLiteJDBC.execute(sql.toString());
	}
	
	protected static void excluiUsuarioPorId(Usuario novo){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM USUARIOS WHERE ID = " + novo.getId());		 
		
		SQLiteJDBC.execute(sql.toString());
	}
	
	protected static void excluiUsuarioPorUserName(Usuario novo){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM USUARIOS WHERE USERNAME = '" + novo.getUsername() + "' ");		 
		
		SQLiteJDBC.execute(sql.toString());
	}
	
	protected static void buscaUsuario(Usuario novo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIOS");		 
		
		SQLiteJDBC.execute(sql.toString());
	}
	
	protected static void buscaUsuarioPorId(Usuario novo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIOS WHERE ID = " + novo.getId());		 
		
		SQLiteJDBC.execute(sql.toString());
	}
	
	protected static void buscaUsuarioPorUserName(Usuario novo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIOS WHERE USERNAME = '" + novo.getUsername() + "' ");		 
		
		SQLiteJDBC.execute(sql.toString());
	}

}
