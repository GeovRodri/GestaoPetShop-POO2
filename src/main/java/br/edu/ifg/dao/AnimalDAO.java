package br.edu.ifg.dao;

import org.springframework.stereotype.Repository;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Animal;

@Repository
public class AnimalDAO extends GenericDao<Animal, Integer> {

	public AnimalDAO() {
		super(Animal.class);
	}
}
