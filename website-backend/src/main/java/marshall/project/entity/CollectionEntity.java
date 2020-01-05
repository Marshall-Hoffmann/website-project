package marshall.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COLLECTION_LIST")
public class CollectionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer collectionId;
	
	private String collectionName;
}
