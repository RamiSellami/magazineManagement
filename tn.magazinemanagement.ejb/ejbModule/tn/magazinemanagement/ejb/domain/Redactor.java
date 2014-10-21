package tn.magazinemanagement.ejb.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Redactor
 *
 */
@Entity

public class Redactor implements Serializable {

	@Id
	private String cinRedactor;
	private String firstName;
	private String lastName;
	private static final long serialVersionUID = 1L;
	@OneToMany(targetEntity = Article.class, mappedBy="redactor")
	private List<Article> articles;
	
	public List<Article> getArticles() {
		return articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	public Redactor() {
		super();
	}   
	
	
	public Redactor(String cinRedactor, String firstName, String lastName) {
		super();
		this.cinRedactor = cinRedactor;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	
	public String getCinRedactor() {
		return this.cinRedactor;
	}

	public void setCinRedactor(String cinRedactor) {
		this.cinRedactor = cinRedactor;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
   
}
