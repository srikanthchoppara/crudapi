package com.rbbn.hibernate.example.crudapi.dao;

import com.rbbn.hibernate.example.crudapi.model.Employee;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeSearch {

	@PersistenceContext
	private EntityManager entityManager;

	private static boolean isAlreadyIndexed = false;

	public void init() {
		if(!isAlreadyIndexed) {
			SearchSession searchSession = Search.session(entityManager);
			MassIndexer indexer = searchSession.massIndexer( Employee.class );
			try {
				indexer.startAndWait();
			} catch (Exception e) {
				e.printStackTrace();
			}
			isAlreadyIndexed = true;
		}
	}
	
	public List<Employee> search() {

		SearchSession searchSession = Search.session(entityManager);
		SearchResult<Employee> result = (SearchResult<Employee>) searchSession.search(Employee.class)
				.where(f -> f.match().field("gender").matching("male")).fetchAll();
		return result.hits();


		/*FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Employee.class).get();
		org.apache.lucene.search.Query query =
		        queryBuilder
		          .keyword()
		          .onFields("name", "department", "gender")
		          .matching(text)
		          .createQuery();
		org.hibernate.search.jpa.FullTextQuery jpaQuery =
		        fullTextEntityManager.createFullTextQuery(query, Employee.class);
		 @SuppressWarnings("unchecked")
		    List results = jpaQuery.getResultList();
		    
		    return results;*/


	}
}
