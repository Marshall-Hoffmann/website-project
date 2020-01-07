package marshall.project.dao;

import java.util.List;

import marshall.project.model.Collection;
import marshall.project.model.TradeItem;

public interface PoeTradeDAO {

	public Integer addTradeItem(TradeItem tradeItem) throws Exception;
	
	public Integer deleteTradeItem(Integer itemId) throws Exception;
	
	public List<TradeItem> getTradeItems(Integer userId) throws Exception;
	
	public List<String> getCollections(Integer userId) throws Exception;
	
	public Integer addCollection(Collection collection) throws Exception;
}
