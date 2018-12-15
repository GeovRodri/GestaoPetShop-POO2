package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClienteDAO extends GenericDao<Cliente, Integer> {

	public ClienteDAO() {
		super(Cliente.class);
	}

	@Transactional(readOnly = true)
	public List<Cliente> buscarPorNome(String nome) {
		try {
			StringBuffer strb = new StringBuffer();

			strb.append("SELECT cliente FROM Cliente cliente");
			strb.append(" WHERE LOWER(cliente.nome) like :nome");

			Query query = getEntityManager().createQuery(strb.toString());
			query.setMaxResults(5);
			query.setParameter("nome", nome.toLowerCase() + "%");

			@SuppressWarnings("unchecked")
			List<Cliente> lst = query.getResultList();

			return lst;
		} catch (NoResultException e) {
			return null;
		}
	}
}
