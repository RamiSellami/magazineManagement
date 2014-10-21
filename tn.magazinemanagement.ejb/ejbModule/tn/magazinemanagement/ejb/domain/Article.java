package tn.magazinemanagement.ejb.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: t_article
 *
 */
@Entity
@Table(name="t_article")

public class Article implements Serializable {

	@EmbeddedId
	@AttributeOverride(name = "publicationDate", column = @Column(name = "publicationDate"))
	private ArticlePK articlePK;

    //MapsId refers to the name of the property in the embedded Id
    @MapsId("idMagazinePK")
    @JoinColumn(name="idMagazinePK")
    @ManyToOne
    private Magazine  magazine;

    @MapsId("cinRedactorPK")
    @JoinColumn(name="cinRedactorPK")
    @ManyToOne
    private Redactor redactor;
	
	private String title;
	private static final long serialVersionUID = 1L;
	@JoinColumn(name="id_section")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Section id_section;
	
	
	
	public ArticlePK getArticlePK() {
		return articlePK;
	}
	
	
	public Article(Magazine magazine, Redactor redactor, String title, Calendar calendar) {
		super();
		this.magazine = magazine;
		this.redactor = redactor;
		this.title = title;
		articlePK = new ArticlePK(redactor.getCinRedactor(), magazine.getIdMagazine(), calendar);
		
		
	}


	public void setArticlePK(ArticlePK articlePK) {
		this.articlePK = articlePK;
	}
	public Magazine getMagazine() {
		return magazine;
	}
	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
	public Redactor getRedactor() {
		return redactor;
	}
	public void setRedactor(Redactor redactor) {
		this.redactor = redactor;
	}
	public Section getId_section() {
		return id_section;
	}
	public void setId_section(Section id_section) {
		this.id_section = id_section;
	}
	public Article(String title, ArticlePK articlePK) {
		super();
		this.title = title;
		this.articlePK = articlePK;
	}
	public Article() {
		super();
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
   
}
