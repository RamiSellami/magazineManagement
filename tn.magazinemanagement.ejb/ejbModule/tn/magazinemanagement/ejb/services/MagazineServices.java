package tn.magazinemanagement.ejb.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import tn.magazinemanagement.ejb.domain.Article;
import tn.magazinemanagement.ejb.domain.Magazine;
import tn.magazinemanagement.ejb.domain.Redactor;
import tn.magazinemanagement.ejb.domain.Section;
import tn.magazinemanagement.ejb.services.interfaces.MagazineServicesRemote;

/**
 * Session Bean implementation class MagazineServices
 */
@Stateless
@LocalBean
public class MagazineServices implements MagazineServicesRemote {
	@PersistenceUnit(name ="magazinemanagement")
	private EntityManagerFactory emf;
	private  EntityManager em ;
	
	
    public EntityManagerFactory getEmf() {
		return emf;
	}
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	private void begin()
	{
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
	}
	/**
     * Default constructor. 
     */
    public MagazineServices() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean createMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		begin();
		em.persist(magazine);
		return true;
	}
	@Override
	public boolean createRedactor(Redactor redactor) {
		// TODO Auto-generated method stub
		begin();
		em.persist(redactor);
		return true;
	}
	@Override
	public boolean createArticle(String nameMagazine, String nameRedactor,
			String lastNameRedactor, String titleArticle,
			Calendar publicationDate) {
		// TODO Auto-generated method stub
		begin();
		
		Magazine magazine;
		try {
			magazine = findMagazineByName(nameMagazine);
			magazine = em.find(Magazine.class, magazine.getIdMagazine());
			magazine = em.contains(magazine) ? magazine : em.merge(magazine);
			Redactor redactor = findRedactorByFirstLastName(nameRedactor, lastNameRedactor);
			redactor = em.find(Redactor.class, redactor.getCinRedactor());
			redactor = em.contains(redactor) ? redactor : em.merge(redactor);
			Article a = new Article(magazine, redactor, titleArticle, Calendar.getInstance());
			em.merge(a);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private Redactor findRedactorByFirstLastName(String nameRedactor,
			String lastNameRedactor) throws Exception {
		// TODO Auto-generated method stub
		begin();
		List<Redactor> redactors = new ArrayList<Redactor>();
		String q = String.format("select r from Redactor r where r.firstName = '%s' and r.lastName = '%s'", nameRedactor, lastNameRedactor);
		redactors = (em.createQuery(q,Redactor.class).getResultList());
		if(redactors.size() >= 1)
		{
			System.out.println("ok");
			return redactors.get(redactors.size() - 1);
		}
		return null ;
	}
	private Magazine findMagazineByName(String nameMagazine) throws Exception
	{
		// TODO Auto-generated method stub
		begin();
		List<Magazine> magazines = new ArrayList<Magazine>();
		String q = String.format("select m from Magazine m where m.name = '%s'", nameMagazine);
		magazines = (em.createQuery(q, Magazine.class).getResultList());
		if(magazines.size() >= 1)
		{
			System.out.println("ok");
			return magazines.get(magazines.size()-1);
		}
		return null;
	}
	@Override
	public boolean updateArticle(String title, String label) {
		begin();
		Section section = new Section();
		section.setLabel(label);
		Article a = findArticleByTitle(title);
		a = em.contains(a) ? a : em.merge(a);
		a.setId_section(section);
		em.merge(a);
		return true;
		
	}
	private Article findArticleByTitle(String title) {
		// TODO Auto-generated method stub
		begin();
		List<Article> articles = new  ArrayList<Article>();
		String q = String.format("select a from Article a where a.title = '%s'", title);
		articles = (em.createQuery(q).getResultList());
		if(articles.size() >= 1)
		{
			System.out.println("ok");
			return articles.get(articles.size() - 1);
		}
		return null;
	}
	@Override
	public List<Article> findAllArticlesByParams(String magazineName,
			String nameRedactor, String lastNameRedactor, String sectionLabel) {
		// TODO Auto-generated method stub
		begin();
		List<Article> articles = new ArrayList<Article>();
		String q = String.format("select a from Article a where a.magazine.name = '%s' and a.redactor.firstName = '%s' and"
				+ " a.redactor.lastName = '%s' and a.id_section.label = '%s' ", magazineName, nameRedactor, lastNameRedactor, sectionLabel);
		articles = ( (List<Article>)em.createQuery(q).getResultList());
		if(articles.size() >= 1)
		{
			System.out.println("ok");
		}
		
		return articles;
		
	}

}
