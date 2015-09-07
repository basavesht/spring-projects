package com.abhi.dao;
 
import java.util.List;
import java.util.Map;
 
import org.springframework.dao.DataAccessException;
 
public interface GenericDao <K , E> {
 
        /**
        * Persist the newInstance object into database.
        * @param entity
        */
        public void persist(E entity) throws DataAccessException ;
 
        /**
        * Save changes made to a persistent object.   
        * @param entity
        */
        public E merge(E entity) throws DataAccessException;
 
        /**
        * Remove an object from persistent storage in the database
        * @param entity
        */
        public void remove(E entity) throws DataAccessException;
 
        /**
        * Retrieve an object that was previously persisted to the database using
        * the indicated id as primary key
        * @param id
        * @return
        */
        public E findById(K id) throws DataAccessException;
 
        /**
        * Retrieve an object by passing the query string.
        * @param queryString
        * @return
        */
        public List<?> find(String queryString) throws DataAccessException;
 
        /**
        * Retrieve an object by passing the query string along with query parameters as an array.
        * @param queryString
        * @param values
        * @return
        */
        public List<?> find(String queryString, Object... values) throws DataAccessException;
 
        /**
        * Retrieve an object by passing the query name
        * @param queryName
        * @return
        */
        public List<?> findByNamedQuery(String queryName) throws DataAccessException;
 
        /**
        * Retrieve an object by passing the query name and the query parameters as an array.
        * @param queryName
        * @param values
        * @return
        */
        public List<?> findByNamedQuery(String queryName, Object... values) throws DataAccessException;
 
        /**
        * Retrieve an object by passing the query name and the query parameters in a Map.
        * Map contains the entries with key as query parameters name and value as query parameters value.
        * @param queryName
        * @param params
        * @return
        */
        public List<?> findByNamedQueryAndNamedParams(String queryName, Map<String,?> params)throws DataAccessException;
 
        /**
        * Checks if the Entity Manager contains the entity instance.
        * @param entity
        * @return
        */
        public boolean contains(E entity) throws DataAccessException;
 
        /**
        * Flush out the
        */
        public void flush() throws DataAccessException;
}