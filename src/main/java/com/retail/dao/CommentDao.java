package com.retail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.retail.model.Blog;
import com.retail.model.Comment;

public class CommentDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("finalProject");
	 EntityManager entityManager=entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();

	 public void insertComment(Comment comment)
	 {
		 try{
		 entityTransaction.begin();
		 entityManager.persist(comment);
		 entityTransaction.commit();
		 }catch(Exception e){
			 e.printStackTrace();
			 //entityTransaction.rollback();
		 }
		
	 }
	 public List<Comment> getComment(){
			System.out.println("get blog");
		Query query1 =
			      entityManager.createNamedQuery("Blog.findAll");
			  List<Comment> results =query1.getResultList();
		return results;
		
	}

}
