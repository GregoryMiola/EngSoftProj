package br.com.engsoftproj.datamenbers;

import java.util.Date;



public class Mudanca {
	private int ID;
	private String TITULO;
	private int ID_DISPOSITIVO;       
	private int ID_USUARIO;	 
	private Date DATA_INI;   
	private Date HORA_INI;
	private Date DATA_FIM;   
	private Date HORA_FIM;
	private String ARQUIVO_INI;
	private String ARQUIVO_FIM;
	private String COMANDOS_APLICADOS;
	private String STATUS;
	//-- ADICIONADO
	private String ANALISADO;
	//-- ADICIONADO
	
	public Mudanca(){
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTITULO() {
		return TITULO;
	}
	public void setTITULO(String tITULO) {
		TITULO = tITULO;
	}
	public int getID_DISPOSITIVO() {
		return ID_DISPOSITIVO;
	}
	public void setID_DISPOSITIVO(int iD_DISPOSITIVO) {
		ID_DISPOSITIVO = iD_DISPOSITIVO;
	}
	public int getID_USUARIO() {
		return ID_USUARIO;
	}
	public void setID_USUARIO(int iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}
	public Date getDATA_INI() {
		return DATA_INI;
	}
	public void setDATA_INI(Date dATA_INI) {
		DATA_INI = dATA_INI;
	}
	public Date getHORA_INI() {
		return HORA_INI;
	}
	public void setHORA_INI(Date hORA_INI) {
		HORA_INI = hORA_INI;
	}
	public Date getDATA_FIM() {
		return DATA_FIM;
	}
	public void setDATA_FIM(Date dATA_FIM) {
		DATA_FIM = dATA_FIM;
	}
	public Date getHORA_FIM() {
		return HORA_FIM;
	}
	public void setHORA_FIM(Date hORA_FIM) {
		HORA_FIM = hORA_FIM;
	}
	public String getARQUIVO_INI() {
		return ARQUIVO_INI;
	}
	public void setARQUIVO_INI(String aRQUIVO_INI) {
		ARQUIVO_INI = aRQUIVO_INI;
	}
	public String getARQUIVO_FIM() {
		return ARQUIVO_FIM;
	}
	public void setARQUIVO_FIM(String aRQUIVO_FIM) {
		ARQUIVO_FIM = aRQUIVO_FIM;
	}
	public String getCOMANDOS_APLICADOS() {
		return COMANDOS_APLICADOS;
	}
	public void setCOMANDOS_APLICADOS(String cOMANDOS_APLICADOS) {
		COMANDOS_APLICADOS = cOMANDOS_APLICADOS;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	//-- ADICIONADO
	public String getANALISADO() {
		return ANALISADO;
	}

	public void setANALISADO(String aNALISADO) {
		ANALISADO = aNALISADO;
	}
	//-- ADICIONADO

}
