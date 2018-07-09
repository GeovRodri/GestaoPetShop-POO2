package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Usuario;

@Repository
public class UsuarioDAO extends GenericDao<Usuario, Integer> {

	public UsuarioDAO() {
		super(Usuario.class);
	}
}
