package br.edu.ifg.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public abstract class GenericDao<T, I extends Serializable> {

	@PersistenceContext
	protected EntityManager entityManager;
	private Class<T> persistedClass;

	protected GenericDao() { }

	protected GenericDao(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	@Transactional
	public T salvar(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public T atualizar(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public void remover(I id) {
		T entity = encontrar(id);
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
	}

	@Transactional(readOnly=true)
	public List<T> getList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	@Transactional(readOnly=true)
	public T encontrar(I id) {
		return entityManager.find(persistedClass, id);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}