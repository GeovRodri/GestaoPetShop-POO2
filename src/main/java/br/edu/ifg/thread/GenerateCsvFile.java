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
		String sFileName = "ordens_de_servico.csv";
		   
		try {
	        FileWriter writer = new FileWriter(sFileName);
	        CharSequence[] osText = new CharSequence[listarOS.size()];
	        int index = 0;
	        for(OrdemServico os : listarOS){
	        	osText[index++] = os.getCliente().getNome() + " " + os.getAnimal().getNome();
	        };
	        
	        
	        writer.flush();
	        writer.close();
	    }catch(IOException e){
	         e.printStackTrace();
	    } 
	}
}
