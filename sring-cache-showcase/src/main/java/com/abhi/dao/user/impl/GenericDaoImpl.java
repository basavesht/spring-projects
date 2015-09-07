package com.abhi.dao.user.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;

import com.abhi.dao.GenericDao;

public class GenericDaoImpl<K extends Serializable, E> implements GenericDao<K, E>
{
	protected Class<E> entityClass;

	@PersistenceContext (unitName = "LocalDB")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		if(this.entityClass == null) {
			ParameterizedType parameterizedType = (ParameterizedType) (this.getClass().getGenericSuperclass());
			while (!(parameterizedType instanceof ParameterizedType)) {
				parameterizedType = (ParameterizedType) parameterizedType.getClass().getGenericSuperclass();
			}
			this.entityClass = (Class<E>) parameterizedType.getActualTypeArguments()[1];
		}
	}

	@Override
	public void persist(final E entity) throws DataAccessException {
		entityManager.persist(entity);
	}

	@Override
	public E merge(final E entity) throws DataAccessException {
		return entityManager.merge(entity);
	}

	@Override
	public void remove(final E entity) throws DataAccessException {
		entityManager.remove(entity);
	}

	@Override
	public E findById(final K id) throws DataAccessException {
		return entityManager.find(entityClass, id);
	}

	@Override
	public List<?> find(String queryString) throws DataAccessException {
		return find(queryString, (Object[]) null);
	}

	@Override
	public List<?> find(String queryString, Object... values) throws DataAccessException {
		Query queryObject = entityManager.createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i + 1, values[i]);
			}
		}
		return queryObject.getResultList();
	}

	@Override
	public List<?> findByNamedQuery(String queryName) throws DataAccessException {
		return findByNamedQuery(queryName, (Object[]) null);
	}

	@Override
	public List<?> findByNamedQuery(String queryName, Object... values) throws DataAccessException {
		Query queryObject = entityManager.createNamedQuery(queryName);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i + 1, values[i]);
			}
		}
		return queryObject.getResultList();
	}

	@Override
	public List<?> findByNamedQueryAndNamedParams(String queryName, Map<String, ?> params) throws DataAccessException {
		Query queryObject = entityManager.createNamedQuery(queryName);
		if (params != null) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				queryObject.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return queryObject.getResultList();
	}

	@Override
	public boolean contains(E entity) throws DataAccessException {
		return entityManager.contains(entity);
	}

	@Override
	public void flush() throws DataAccessException {
		entityManager.flush();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}