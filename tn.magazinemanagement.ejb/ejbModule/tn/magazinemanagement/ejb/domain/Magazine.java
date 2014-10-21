package tn.magazinemanagement.ejb.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Magazine
 *
 */
@Entity
@Table(name = "t_magazine")
public class Magazine implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMagazine;
	private String name;
	private String format;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="magazine")
	List<Article> articles;
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Magazine(String n, String f)
	{
		this.name = n;
		this.format = f;
	}
	public Magazine() {
		super();
	}   
	    
	public int getIdMagazine() {
		return this.idMagazine;
	}

	public void setIdMagazine(int idMagazine) {
		this.idMagazine = idMagazine;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
   
}
