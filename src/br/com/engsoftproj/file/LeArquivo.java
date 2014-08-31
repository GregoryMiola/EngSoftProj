package br.com.engsoftproj.file;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeArquivo {

	public static void main(String[] args)throws IOException {
		
	File arq = new File("./src/br/com/engsoftproj/file/teste.txt");
	arq.createNewFile();
	  try{  
	      
	      BufferedReader br = new BufferedReader(new FileReader("./src/br/com/engsoftproj/file/teste.txt"));  
	   
	          while(br.ready()){  
	             String linha = br.readLine();  
	             System.out.println(linha);  
	          }  
	          br.close();  
	       }catch(IOException ioe){  
	          ioe.printStackTrace();  
	       } 		
	}
}
