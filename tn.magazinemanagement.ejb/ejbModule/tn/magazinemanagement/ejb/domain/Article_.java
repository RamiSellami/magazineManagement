package tn.magazinemanagement.ejb.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-21T20:50:26.586+0100")
@StaticMetamodel(Article.class)
public class Article_ {
	public static volatile SingularAttribute<Article, ArticlePK> articlePK;
	public static volatile SingularAttribute<Article, Magazine> magazine;
	public static volatile SingularAttribute<Article, Redactor> redactor;
	public static volatile SingularAttribute<Article, String> title;
	public static volatile SingularAttribute<Article, Section> id_section;
}
