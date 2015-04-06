package com.retail.model;
	import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
	@Table(name="blog")
	@Entity
	@NamedQuery(name="Blog.findAll",query="select b from Blog b")

	public class Blog {
		public Blog() {
			// TODO Auto-generated constructor stub
		}
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int blogId;
		@Column(name="blogDate") 
		private String blogDate;
		 @Column(nullable=false)
		 private String blogName;
		 @Column(name = "latestEditDate" ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable=false,updatable=false)
		 private Date latestEditDate;
		 @OneToMany
		 List<Comment> commentList=new  ArrayList<>();
		 @OneToOne
		 private Category category;
		 @Column(nullable=true)
		 private String blogStatus;
		 @Column(nullable=false,name="image")
		 private byte[][] image;
		 @Column(nullable=false,name="blogContent")
		 private String blogContent;
		 @OneToOne
		 private Customer customer;
		 
		 
		 
		 
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public int getBlogId() {
			return blogId;
		}
		public void setBlogId(int blogId) {
			this.blogId = blogId;
		}
		public String getBlogDate() {
			return blogDate;
		}
		public void setBlogDate(String blogDate) {
			this.blogDate = blogDate;
		}
		public String getBlogName() {
			return blogName;
		}
		public void setBlogName(String blogName) {
			this.blogName = blogName;
		}
		public Date getLatestEditDate() {
			return latestEditDate;
		}
		public void setLatestEditDate(Date latestEditDate) {
			this.latestEditDate = latestEditDate;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getBlogStatus() {
			return blogStatus;
		}
		public void setBlogStatus(String blogStatus) {
			this.blogStatus = blogStatus;
		}
		public byte[][] getImage() {
			return image;
		}
		public void setImage(byte[][] image) {
			this.image = image;
		}
		public String getBlogContent() {
			return blogContent;
		}
		public void setBlogContent(String blogContent) {
			this.blogContent = blogContent;
		}
		@Override
		public String toString() {
			return "Blog [blogId=" + blogId + ", blogDate=" + blogDate
					+ ", blogName=" + blogName + ", latestEditDate="
					 + ", commentList=" + commentList
					+ ", category=" + category + ", blogStatus=" + blogStatus
					+ ", blogContent=" + blogContent + ", customer=" + customer
					+ "]";
		}
		
		 
		 
	}


