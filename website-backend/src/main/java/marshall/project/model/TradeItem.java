package marshall.project.model;

public class TradeItem {
	private Integer itemId;
	private String name;
	private String description;
	private String tradeUrl;
	private String priceHistoryUrl;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
}
