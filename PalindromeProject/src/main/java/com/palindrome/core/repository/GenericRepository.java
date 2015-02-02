package com.palindrome.core.repository;

import java.util.List;

public interface GenericRepository<E, K> {

	void add(E entity);

	void update(E entity);

	void remove(E entity);

	E find(K key);

	List<E> list();

}
