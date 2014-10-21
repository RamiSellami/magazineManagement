package tn.magazinemanagement.ejb.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Section
 *
 */
@Entity

public class Section implements Serializable {

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSection;
	@Column(name="c_label")
	private String label;
	@OneToMany(mappedBy="id_section")
	private List<Article> sectionArticles;
	
	public List<Article> getSectionArticles() {
		return sectionArticles;
	}

	public void setSectionArticles(List<Article> sectionArticles) {
		this.sectionArticles = sectionArticles;
	}

	private static final long serialVersionUID = 1L;

	public Section() {
		super();
	}   
	  
	public int getIdSection() {
		return this.idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}   
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
   
}
