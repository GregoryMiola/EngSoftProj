package br.com.engsoftproj.cadastros;

import br.com.engsoftproj.datamenbers.Mudanca;
import br.com.engsoftproj.db.SQLiteJDBC;

public class CadastroMudancasDAO {
	
	protected static void salvaMudanca(Mudanca mudanca){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MUDANCAS (TITULO, ID_EQUIPAMENTO, ID_USUARIO, DATA_INI, HORA_INI, ");
		sql.append(" DATA_FIM, HORA_FIM, ARQUIVO_INI, ARQUIVO_FIM, COMANDOS_APLICADOS, STATUS) ");
		sql.append("VALUES ('" + mudanca.getTITULO() + "', '" + mudanca.getID_DISPOSITIVO() + "', '" + mudanca.getID_USUARIO() + "', ");
		sql.append(" '" + mudanca.getDATA_INI() + "', '" + mudanca.getHORA_INI() + "', '" + mudanca.getDATA_FIM() + "', '" + mudanca.getHORA_FIM() + "', " );
		sql.append(" '" + mudanca.getARQUIVO_INI() + "', '" + mudanca.getARQUIVO_FIM() + "', '" + mudanca.getCOMANDOS_APLICADOS() + "', '" + mudanca.getSTATUS() + "') ");
		
		SQLiteJDBC.execute(sql.toString());
	}

}
