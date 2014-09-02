package br.com.engsoftproj.cadastros;


import br.com.engsoftproj.datamenbers.Dispositivo;
import br.com.engsoftproj.db.SQLiteJDBC;

public class CadastroDispositivoDAO {
	
	protected static void salvaDispositivo(Dispositivo disp){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO DEVICES (NOME, ENDERECO, TIPO) ");
		sql.append("VALUES ('" + disp.getNOME() + "', '" + disp.getCODIGO() + "', '" + disp.getTIPO() + "') "); 
		
		SQLiteJDBC.execute(sql.toString());
	}

}
