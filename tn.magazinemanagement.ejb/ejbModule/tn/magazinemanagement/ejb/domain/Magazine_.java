package tn.magazinemanagement.ejb.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-21T20:29:53.236+0100")
@StaticMetamodel(Magazine.class)
public class Magazine_ {
	public static volatile SingularAttribute<Magazine, Integer> idMagazine;
	public static volatile SingularAttribute<Magazine, String> name;
	public static volatile SingularAttribute<Magazine, String> format;
	public static volatile ListAttribute<Magazine, Article> articles;
}
