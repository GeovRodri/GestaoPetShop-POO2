package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Cliente;

@Repository
public class ClienteDAO extends GenericDao<Cliente, Integer> {

	public ClienteDAO() {
		super(Cliente.class);
	}
}
