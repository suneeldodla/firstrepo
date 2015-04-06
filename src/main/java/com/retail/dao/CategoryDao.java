package com.retail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.retail.model.Category;

public class CategoryDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("finalProject");
	 EntityManager entityManager=entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();
	 public void insertCategory(Category category)
	 {
		 
		 entityTransaction.begin();
		 entityManager.persist(category);
		 entityTransaction.commit();
	 }
	 public List<String> getCategory(){
			System.out.println("get category");
		Query query1 =
			      entityManager.createNamedQuery("Category.findAll");
			  List<String> results =query1.getResultList();
		return results;
		
	}
	 
}
