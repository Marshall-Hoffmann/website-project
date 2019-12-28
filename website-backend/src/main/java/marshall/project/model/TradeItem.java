package marshall.project.model;

public class TradeItem {
	private Integer tradeId;
	private String name;
	private String description;
	private String tradeUrl;
	private String priceHistoryUrl;
	
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
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
