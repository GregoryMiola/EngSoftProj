package br.com.engsoftproj.file;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class EscreveArquivo {
	    private static final String path = "./src/br/com/engsoftproj/file/write_test.txt";  
	    public static void main(String[] args) throws IOException {  
	        File file = new File(path);  
	        long begin = System.currentTimeMillis();  
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));  
	        writer.write("Arquivo gravado em : " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));  
	        writer.newLine();  
	        writer.write("Caminho da grava��o: " + path);  
	        writer.newLine();  
	        long end = System.currentTimeMillis();  
	        writer.write("Tempo de grava��o: " + (end - begin) + "ms.");  
	        //Criando o conte�do do arquivo  
	        writer.flush();  
	        //Fechando conex�o e escrita do arquivo.  
	        writer.close();  
	          
	        System.out.println("Arquivo gravado em: " + path);  
	    }  
	}
