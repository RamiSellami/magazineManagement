package tn.magazinemanagement.ejb.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-21T21:19:09.438+0100")
@StaticMetamodel(Redactor.class)
public class Redactor_ {
	public static volatile SingularAttribute<Redactor, String> cinRedactor;
	public static volatile SingularAttribute<Redactor, String> firstName;
	public static volatile SingularAttribute<Redactor, String> lastName;
	public static volatile ListAttribute<Redactor, Article> articles;
}
