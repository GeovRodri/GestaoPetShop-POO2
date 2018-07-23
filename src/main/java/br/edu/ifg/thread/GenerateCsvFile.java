package br.edu.ifg.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.OrdemServico;

public class GenerateCsvFile extends Thread{
	
	public void run(){
	
		OrdemServicoDAO OsDAO = new OrdemServicoDAO();
		List<OrdemServico> listarOS = OsDAO.getList();
		String sFileName = null;
		   
		try {
	        FileWriter writer = new FileWriter(sFileName);
	        int i;
	        for(i=0; i<listarOS.size(); i++ ){
	        	writer.append((CharSequence) listarOS.get(i));
	        };
	        writer.flush();
	        writer.close();
	    }catch(IOException e){
	         e.printStackTrace();
	    } 
	}
}
