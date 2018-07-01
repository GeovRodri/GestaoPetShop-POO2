package br.edu.ifg.dao;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.OrdemServico;

public class OrdemServicoDAO extends GenericDao<OrdemServico, Integer> {

	public OrdemServicoDAO() {
		super(OrdemServico.class);
	}
}
