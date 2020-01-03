package marshall.project.service;

import java.util.List;

import marshall.project.model.TradeItem;

public interface PoeTradeService {

	public Integer addTradeItem(TradeItem tradeItem) throws Exception;
	
	public Integer deleteTradeItem(Integer itemId) throws Exception;
	
	public List<TradeItem> getTradeItems(String emailId) throws Exception;
	
}
