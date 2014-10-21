package tn.magazinemanagement.ejb.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.ejb.Timeout;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ArticlePK implements Serializable
{
	private String cinRedactorPK;
	private Integer idMagazinePK;
	@Temporal(TemporalType.DATE)
	private Calendar publicationDate;
	
	
	
	public ArticlePK() {
		super();
	}
	public ArticlePK(String cinRedactorPK, Integer idMagazinePK,
			Calendar publicationDate) {
		super();
		this.cinRedactorPK = cinRedactorPK;
		this.idMagazinePK = idMagazinePK;
		this.publicationDate = publicationDate;
	}
	public String getCinRedactorPK() {
		return cinRedactorPK;
	}
	public void setCinRedactorPK(String cinRedactorPK) {
		this.cinRedactorPK = cinRedactorPK;
	}
	public Integer getIdMagazinePK() {
		return idMagazinePK;
	}
	public void setIdMagazinePK(Integer idMagazinePK) {
		this.idMagazinePK = idMagazinePK;
	}
	public Calendar getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Calendar publicationDate) {
		this.publicationDate = publicationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cinRedactorPK == null) ? 0 : cinRedactorPK.hashCode());
		result = prime * result
				+ ((idMagazinePK == null) ? 0 : idMagazinePK.hashCode());
		result = prime * result
				+ ((publicationDate == null) ? 0 : publicationDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticlePK other = (ArticlePK) obj;
		if (cinRedactorPK == null) {
			if (other.cinRedactorPK != null)
				return false;
		} else if (!cinRedactorPK.equals(other.cinRedactorPK))
			return false;
		if (idMagazinePK == null) {
			if (other.idMagazinePK != null)
				return false;
		} else if (!idMagazinePK.equals(other.idMagazinePK))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		return true;
	}
	
	
}
