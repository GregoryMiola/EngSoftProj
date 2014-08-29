package br.com.engsoftproj.db;

import java.sql.*;

import br.com.engsoftproj.datamenbers.Usuario;
import br.com.engsoftproj.enumerators.NivelAcesso;

public class SQLiteJDBC
{
	private static Connection c = null;
	private static Statement stmt = null;
	static final String JDBC_DRIVER = "org.sqlite.JDBC";
	
	public static void main( String args[] )
	{	    
	    try {
	      Class.forName(JDBC_DRIVER);
	      c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
	      
	      System.out.println("Opened database successfully");
	      stmt = c.createStatement();
	      
	      String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='USUARIOS';";
	      ResultSet rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	    	  sql = "";
	    	  sql = "CREATE TABLE USUARIOS " +
	    		  	   "(ID 			INT PRIMARY KEY     	NOT NULL, " +
	                   " NOME           TEXT    				NOT NULL, " +
	                   " CARGO       	TEXT     				NOT NULL, " +
	                   " USERNAME		TEXT   					NOT NULL, " + 
	                   " PASSWORD      	CHAR(6)					NOT NULL, " +
	                   " NIVEL_ACESSO  	CHAR(1)					NOT NULL)"; 
	    	  stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='DEVICES';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	    	  sql = "";
	    	  sql = "CREATE TABLE DEVICES " +
	              "(ID 				INT PRIMARY KEY     	NOT NULL,"  +
	              " NOME            TEXT    				NOT NULL, " +
	              " ENDERECO       	TEXT     				NOT NULL, " +
	              " TIPO			TEXT     				NOT NULL)";
	    	  stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='MUDANCAS';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	      	sql = "";
	      	sql = "CREATE TABLE MUDANCAS " +
	              "(ID 					INT PRIMARY KEY     	NOT NULL,"  +
	              " TITULO         		TEXT    				NOT NULL, " +
	              " ID_EQUIPAMENTO    	INT     				NOT NULL, " +
	              " ID_USUARIO			INT   					NOT NULL, " + 
	              " DATA_INI       		DATE					NOT NULL, " +
	              " HORA_INI       		DATE					NOT NULL, " +
	              " DATA_FIM       		DATE					NOT NULL, " +
	              " HORA_FIM       		DATE					NOT NULL, " +
	              " ARQUIVO_INI     	CHAR(5000)				NOT NULL, " +
	              " ARQUIVO_FIM     	CHAR(5000)				NOT NULL, " +
	              " COMANDOS_APLICADOS  CHAR(5000)				NOT NULL, " +
	              " STATUS			    CHAR(1)					NOT NULL, " +
	              " FOREIGN KEY(ID_EQUIPAMENTO) REFERENCES DEVICES(ID), " +
	              " FOREIGN KEY(ID_USUARIO) 	REFERENCES USUARIOS(ID))"; 
	      	stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT * FROM USUARIOS WHERE NOME = 'root' AND NIVEL_ACESSO = '0';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	    	  sql = "";
	    	  sql = "INSERT INTO USUARIOS (ID, NOME, CARGO, USERNAME, PASSWORD, NIVEL_ACESSO)" +
	    			  "VALUES (1, 'root', 'root', 'root', '123456', '0');"; 
	    	  stmt.executeUpdate(sql);
	      }
	      
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	  }
	  
	public static Usuario verificaLogin(String user, String passwd) {
		boolean result = false;
		Usuario loged = null;  
		
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();
					  
			String sql = "SELECT * FROM USUARIOS WHERE USERNAME = '" + user + "' AND PASSWORD = '" + passwd + "';";
			ResultSet rs = stmt.executeQuery(sql);
	      
			while (rs.next()) {
				loged = new Usuario();
		        loged.setId(rs.getInt("ID"));
		        loged.setNome(rs.getString("NOME"));
		        loged.setCargo(rs.getString("CARGO"));
		        loged.setUsername(rs.getString("USERNAME"));
		        loged.setPassword(rs.getString("PASSWORD"));
		        loged.setNivelAcesso(NivelAcesso.values()[rs.getInt("NIVEL_ACESSO")]);
		        break;
			}
			
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
		  
	  	return loged;
  	}
}