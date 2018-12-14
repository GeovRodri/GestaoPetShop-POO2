package br.edu.ifg.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.edu.ifg.util.Utils;
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
			PrintWriter writer = new PrintWriter(sFileName);
			StringBuilder sb = new StringBuilder();
	        
	        for(OrdemServico os : listarOS){
				sb.append("Id,Cliente,Animal,Data\n");
	        	sb.append(os.getId());
	        	sb.append(",");
	        	sb.append(os.getAnimal().getCliente().getNome());
				sb.append(",");
				sb.append(os.getAnimal().getNome());
				sb.append(",");
				sb.append(Utils.dateToString(os.getDataCad()));
				sb.append("\n");
	        }

			writer.append(sb.toString());
	        writer.flush();
	        writer.close();
	    }catch(IOException e){
	         e.printStackTrace();
	    } 
	}
}
