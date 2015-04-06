package com.retail.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.retail.model.Blog;

public class BlogDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("finalProject");
	 EntityManager entityManager=entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();

	 public void insertBlog(Blog blog)
	 {

		
		 try{
		 entityTransaction.begin();
		 entityManager.persist(blog);
		 entityTransaction.commit();
		 }catch(Exception e){
			 e.printStackTrace();
			 //entityTransaction.rollback();
		 }
		
	 }
	 public List<Blog> getBlog(){
			System.out.println("get blog");
		Query query1 =
			      entityManager.createNamedQuery("Blog.findAll");
			  List<Blog> results =query1.getResultList();
		return results;
		
	}
	}


