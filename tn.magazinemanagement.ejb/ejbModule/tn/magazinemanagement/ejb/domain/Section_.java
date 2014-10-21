package tn.magazinemanagement.ejb.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-21T20:08:33.423+0100")
@StaticMetamodel(Section.class)
public class Section_ {
	public static volatile SingularAttribute<Section, Integer> idSection;
	public static volatile SingularAttribute<Section, String> label;
	public static volatile ListAttribute<Section, Article> sectionArticles;
}
