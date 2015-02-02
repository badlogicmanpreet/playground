package com.palindrome.core.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRepository<E, K> implements GenericRepository<E, K> {

	private List<E> entities = new ArrayList<E>();

	@Override
	public void add(E entity) {
		entities.add(entity);
	}

	@Override
	public void update(E entity) {
		throw new UnsupportedOperationException("Not supported for InMemory Storage");
	}

	@Override
	public void remove(E entity) {
		entities.remove(entity);
	}

	@Override
	public E find(K key) {
		if (entities.isEmpty()) {
			return null;
		}
		return entities.get(0);
	}

	@Override
	public List<E> list() {
		return entities;
	}

}
