package marshall.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SEARCH_COLLECTION_LIST")
public class SearchCollectionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer searchCollectionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="COLLECTION_ID")
	private CollectionEntity collectionEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SEARCH_ID")
	private TradeItemEntity tradeItemEntity;
}
