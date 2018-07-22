package br.edu.ifg.csv;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.OrdemServico;

public class testeCSV {
	
	public static void main(String[] args) {
		
		OrdemServicoDAO os = new OrdemServicoDAO();
		
		
		System.out.println(os.toString());
		
		
	}

}
