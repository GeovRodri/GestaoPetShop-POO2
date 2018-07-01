package br.edu.ifg.dao;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Usuario;

public class UsuarioDAO extends GenericDao<Usuario, Integer> {

	public UsuarioDAO() {
		super(Usuario.class);
	}
}
