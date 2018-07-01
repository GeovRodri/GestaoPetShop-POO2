package br.edu.ifg.dao;

import br.edu.ifg.common.GenericDao;
import br.edu.ifg.entity.Animal;

public class AnimalDAO extends GenericDao<Animal, Integer> {

	public AnimalDAO() {
		super(Animal.class);
	}
}
