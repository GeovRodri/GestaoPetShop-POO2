package br.edu.ifg.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.edu.ifg.entity.Cliente;

public class generateCsvFile extends Thread{
	
private static void generateCsvFile(String sFileName, List<Cliente> lista){
	    
		try {
	        FileWriter writer = new FileWriter(sFileName);
	        writer = (FileWriter) lista;
	        writer.flush();
	        writer.close();
	    }catch(IOException e){
	         e.printStackTrace();
	    } 
	}

}
