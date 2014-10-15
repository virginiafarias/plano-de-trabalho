package br.ufc.bcq.repositorio;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.ufc.bcq.model.enumerator.QueryType;

public interface GenericRepositorio<T> {

	void setEntityManager(EntityManager em);

	void save(T entity);

	void update(T entity);

	void delete(T entity);

	T find(Class<T> entityClass, Object id);

	List<T> find(Class<T> entityClass);

	List<T> find(Class<T> entityClass, int firstResult, int maxResults);

	List<T> find(String queryName, Map<String, Object> namedParams);

	List<T> find(QueryType type, String query, Map<String, Object> namedParams);

	List<T> find(String queryName, Map<String, Object> namedParams,
			int firstResult, int maxResults);

	List<T> find(QueryType type, String query, Map<String, Object> namedParams,
			int firstResult, int maxResults);

	T findFirst(String query, Map<String, Object> namedParams);

	T findFirst(String query, Map<String, Object> namedParams, int firstResult,
			int maxResults);

	T findFirst(QueryType type, String query, Map<String, Object> namedParams,
			int firstResult, int maxResults);

}