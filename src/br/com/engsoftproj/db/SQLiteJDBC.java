package br.com.engsoftproj.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.engsoftproj.datamenbers.Dispositivo;
import br.com.engsoftproj.datamenbers.Mudanca;
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
	    		  	   "(ID 			INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL, " +
	                   " NOME           TEXT    							NOT NULL, " +
	                   " CARGO       	TEXT     							NOT NULL, " +
	                   " USERNAME		TEXT   								NOT NULL, " + 
	                   " PASSWORD      	VARCHAR(6)							NOT NULL, " +
	                   " NIVEL_ACESSO  	VARCHAR(1)							NOT NULL)"; 
	    	  stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='DEVICES';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	    	  sql = "";
	    	  sql = "CREATE TABLE DEVICES " +
	              "(ID 				INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL,"  +
	              " NOME            TEXT    							NOT NULL, " +
	              " ENDERECO       	TEXT     							NOT NULL, " +
	              " TIPO			TEXT     							NOT NULL)";
	    	  stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='MUDANCAS';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	      	sql = "";
	      	sql = "CREATE TABLE MUDANCAS " +
	              "(ID 					INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL,"  +
	              " TITULO         		TEXT    							NOT NULL, " +
	              " ID_EQUIPAMENTO    	INTEGER    							NOT NULL, " +
	              " ID_USUARIO			INTEGER								NOT NULL, " + 
	              " DATA_INI       		DATE								NOT NULL, " +
	              " HORA_INI       		DATE								NOT NULL, " +
	              " DATA_FIM       		DATE								NOT NULL, " +
	              " HORA_FIM       		DATE								NOT NULL, " +
	              " ARQUIVO_INI     	VARCHAR(5000)						NOT NULL, " +
	              " ARQUIVO_FIM     	VARCHAR(5000)						NOT NULL, " +
	              " COMANDOS_APLICADOS  VARCHAR(5000)						NOT NULL, " +
	              " STATUS			    VARCHAR(1)							NOT NULL, " +
	              " ANALISADO			TEXT								NOT NULL, " +
	              " FOREIGN KEY(ID_EQUIPAMENTO) REFERENCES DEVICES(ID), " +
	              " FOREIGN KEY(ID_USUARIO) 	REFERENCES USUARIOS(ID))"; 
	      	stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT * FROM USUARIOS WHERE NOME = 'root' AND NIVEL_ACESSO = '0';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	    	  sql = "";
	    	  sql = "INSERT INTO USUARIOS (NOME, CARGO, USERNAME, PASSWORD, NIVEL_ACESSO)" +
	    			  "VALUES ('root', 'root', 'root', '123456', '0');"; 
	    	  stmt.executeUpdate(sql);
	      }
	      
	      sql = "SELECT * FROM USUARIOS WHERE NOME = 'tectest' AND NIVEL_ACESSO = '2';";
	      rs = stmt.executeQuery(sql);
	      if(!rs.next())
	      {
	    	  sql = "";
	    	  sql = "INSERT INTO USUARIOS (NOME, CARGO, USERNAME, PASSWORD, NIVEL_ACESSO)" +
	    			  "VALUES ('tectest', 'tectest', 'tectest', '123456', '2');"; 
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
	
	/*
	public static void insereUsuario(Usuario user) {
				
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();
			
			String  sql = String.format("INSERT INTO USUARIOS (NOME, CARGO, USERNAME, PASSWORD, NIVEL_ACESSO) VALUES ('%s', '%s', '%s', '%s', '%d');", 
					user.getNome(), user.getCargo(), user.getUsername(), user.getPassword(), user.getNivelAcesso().getValue()); 
    	    stmt.executeUpdate(sql);
			
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
  	}
	*/
	
	public static void execute(String sql) {
		
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();			
			 
    	    stmt.executeUpdate(sql);
			
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
  	}
	
	//-- adicionado
	public static List<String> getLista(String sql){
		List<String> lst = new ArrayList<String>();
		
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();
			 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				lst.add(rs.getString(1) + " - " + rs.getString(2));
			}
			
			stmt.close();
			c.close();
			rs.close();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
		
		return lst;
	}
	
	public Usuario getUsuario(String sql){
		//List<String> lst = new ArrayList<String>();
		
		Usuario user = null;
		
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();			 
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()){				
				user.setId(rs.getInt("ID"));
				user.setNome(rs.getString("NOME"));
				user.setCargo(rs.getString("CARGO"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setNivelAcesso(NivelAcesso.values()[rs.getInt("NIVEL_ACESSO")]);
		        break;
			}
			
			stmt.close();
			c.close();
			rs.close();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
		
		return user;
	}
	
	public Dispositivo getDispositivo(String sql){
		//List<String> lst = new ArrayList<String>();
		
		Dispositivo disp = null;
		
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();			 
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()){				
				disp.setID(rs.getInt("ID"));
				disp.setNOME(rs.getString("NOME"));
				disp.setCODIGO(rs.getString("ENDERECO"));
				disp.setTIPO(rs.getString("TIPO"));				
		        break;
			}
			
			stmt.close();
			c.close();
			rs.close();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
		
		return disp;
	}
	
	public Mudanca getMudanca(String sql){
		//List<String> lst = new ArrayList<String>();
		
		Mudanca mudanca = null;
		
		try{
			c = DriverManager.getConnection("jdbc:sqlite:sistema.db");
			stmt = c.createStatement();			 
			ResultSet rs = stmt.executeQuery(sql);			
			
			while(rs.next()){				
				mudanca.setID(rs.getInt("ID"));
				mudanca.setTITULO(rs.getString("TITULO"));
				mudanca.setID_DISPOSITIVO(rs.getInt("ID_EQUIPAMENTO"));
				mudanca.setID_USUARIO(rs.getInt("ID_USUARIO"));
				mudanca.setDATA_INI(rs.getDate("DATA_INI"));
				mudanca.setHORA_INI(rs.getDate("HORA_INI"));
				mudanca.setDATA_FIM(rs.getDate("DATA_FIM"));
				mudanca.setHORA_INI(rs.getDate("HORA_FIM"));
				mudanca.setARQUIVO_INI(rs.getString("ARQUIVO_INI"));
				mudanca.setARQUIVO_FIM(rs.getString("ARQUIVO_FIM"));
				mudanca.setCOMANDOS_APLICADOS(rs.getString("COMANDOS_APLICADOS"));
				mudanca.setSTATUS(rs.getString("STATUS"));
				mudanca.setANALISADO(rs.getString("ANALISADO"));								
		        break;
			}
			
			stmt.close();
			c.close();
			rs.close();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	  	}
		
		return mudanca;		
	}
	//-- adicionado
	
	
}