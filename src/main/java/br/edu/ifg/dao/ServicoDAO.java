package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Servico;

@Repository
public class ServicoDAO extends GenericDao<Servico, Integer> {

	public ServicoDAO() {
		super(Servico.class);
	}
}
