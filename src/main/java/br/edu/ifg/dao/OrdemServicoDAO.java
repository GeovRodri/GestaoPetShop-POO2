package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.OrdemServico;

@Repository
public class OrdemServicoDAO extends GenericDao<OrdemServico, Integer> {

	public OrdemServicoDAO() {
		super(OrdemServico.class);
	}
}
