package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Animal;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AnimalDAO extends GenericDao<Animal, Integer> {

	public AnimalDAO() {
		super(Animal.class);
	}

	@Transactional(readOnly = true)
	public List<Animal> buscarPorNome(String nome) {
		try {
			StringBuffer strb = new StringBuffer();

			strb.append("SELECT animal FROM Animal animal");
			strb.append(" WHERE LOWER(animal.nome) like :nome");

			Query query = getEntityManager().createQuery(strb.toString());
			query.setMaxResults(5);
			query.setParameter("nome", nome.toLowerCase() + "%");

			@SuppressWarnings("unchecked")
			List<Animal> lst = query.getResultList();

			return lst;
		} catch (NoResultException e) {
			return null;
		}
	}
}
