package tn.magazinemanagement.ejb.domain;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-21T21:08:17.163+0100")
@StaticMetamodel(ArticlePK.class)
public class ArticlePK_ {
	public static volatile SingularAttribute<ArticlePK, String> cinRedactorPK;
	public static volatile SingularAttribute<ArticlePK, Integer> idMagazinePK;
	public static volatile SingularAttribute<ArticlePK, Calendar> publicationDate;
}
