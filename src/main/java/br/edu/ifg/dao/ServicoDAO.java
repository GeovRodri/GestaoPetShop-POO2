package br.edu.ifg.dao;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Servico;

public class ServicoDAO extends GenericDao<Servico, Integer> {

	public ServicoDAO() {
		super(Servico.class);
	}
}
