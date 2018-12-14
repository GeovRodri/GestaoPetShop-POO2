package br.edu.ifg.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.OrdemServico;

public class GenerateCsvFile extends Thread {
	
	@Autowired
	private OrdemServicoDAO ordemServicoDAO;
	
	public void run(){
		List<OrdemServico> listarOS = ordemServicoDAO.listarComFatch();
		String sFileName = "ordens_de_servico.csv";
		   
		try {
	        FileWriter writer = new FileWriter(sFileName);
	        
	        for(OrdemServico os : listarOS){
	        	CharSequence osText = os.getId() + ", " + os.getAnimal().getCliente().getNome() + ", " + os.getAnimal().getNome() + "\n";
	        	writer.append(osText);
	        };
	        
	        writer.flush();
	        writer.close();
	    }catch(IOException e){
	         e.printStackTrace();
	    } 
	}
}
