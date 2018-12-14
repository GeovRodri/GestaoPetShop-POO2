package br.edu.ifg.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.ItemOrdemServico;
import br.edu.ifg.entity.OrdemServico;

@Repository
public class OrdemServicoDAO extends GenericDao<OrdemServico, Integer> {

	public OrdemServicoDAO() {
		super(OrdemServico.class);
	}
	
	@Transactional(readOnly = true)
	public List<OrdemServico> listarComFatch() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OrdemServico> criteria = builder.createQuery(OrdemServico.class);
		Root<OrdemServico> from = criteria.from(OrdemServico.class);
		
		FetchParent<OrdemServico, Animal> fetchAnimal = from.fetch("animal");
		FetchParent<OrdemServico, Cliente> fetchCliente = fetchAnimal.fetch("cliente");

		FetchParent<OrdemServico, ItemOrdemServico> fetch = from.fetch("itens");
		
		TypedQuery<OrdemServico> typedQuery = entityManager.createQuery(criteria);
		return typedQuery.getResultList();
	}
}
