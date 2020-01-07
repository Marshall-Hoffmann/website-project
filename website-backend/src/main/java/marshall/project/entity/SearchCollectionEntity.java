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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="LEAGUE_ID")
	private LeagueEntity leagueEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private UserEntity userEntity;

	public Integer getSearchCollectionId() {
		return searchCollectionId;
	}

	public void setSearchCollectionId(Integer searchCollectionId) {
		this.searchCollectionId = searchCollectionId;
	}

	public CollectionEntity getCollectionEntity() {
		return collectionEntity;
	}

	public void setCollectionEntity(CollectionEntity collectionEntity) {
		this.collectionEntity = collectionEntity;
	}

	public TradeItemEntity getTradeItemEntity() {
		return tradeItemEntity;
	}

	public void setTradeItemEntity(TradeItemEntity tradeItemEntity) {
		this.tradeItemEntity = tradeItemEntity;
	}

	public LeagueEntity getLeagueEntity() {
		return leagueEntity;
	}

	public void setLeagueEntity(LeagueEntity leagueEntity) {
		this.leagueEntity = leagueEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
}
