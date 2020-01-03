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
@Table(name="TRADE_LIST")
public class TradeItemEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	
	private String name;
	
	private String description;
	
	private String tradeUrl;
	
	private String priceHistoryUrl;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="EMAIL_ID")
	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTradeUrl() {
		return tradeUrl;
	}

	public void setTradeUrl(String tradeUrl) {
		this.tradeUrl = tradeUrl;
	}

	public String getPriceHistoryUrl() {
		return priceHistoryUrl;
	}

	public void setPriceHistoryUrl(String priceHistoryUrl) {
		this.priceHistoryUrl = priceHistoryUrl;
	}
	

}
