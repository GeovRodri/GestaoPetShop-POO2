package br.edu.ifg.dao;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Cliente;

public class ClienteDAO extends GenericDao<Cliente, Integer> {

	public ClienteDAO() {
		super(Cliente.class);
	}
}
