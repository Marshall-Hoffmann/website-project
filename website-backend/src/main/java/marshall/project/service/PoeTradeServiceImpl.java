package marshall.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marshall.project.dao.PoeTradeDAO;
import marshall.project.model.Collection;
import marshall.project.model.TradeItem;

@Service
@Transactional
public class PoeTradeServiceImpl implements PoeTradeService {

	@Autowired
	PoeTradeDAO poeTradeDAO;
	
	@Override
	public Integer addTradeItem(TradeItem tradeItem) throws Exception {
		Integer itemId;
		try {
			itemId = poeTradeDAO.addTradeItem(tradeItem);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return itemId;
	}
	
	@Override
	public Integer deleteTradeItem(Integer itemId) throws Exception {
		try {
			itemId = poeTradeDAO.deleteTradeItem(itemId);
		} catch (Exception e){
			throw new Exception(e);
		}
		return itemId;
	}
	
	@Override
	public List<TradeItem> getTradeItems(Integer userId) throws Exception {
		List<TradeItem> itemList;
		try {
			itemList = poeTradeDAO.getTradeItems(userId); 
		} catch (Exception e) {
			throw new Exception(e);
		}
		return itemList;
	}
	
	@Override
	public List<String> getCollections(Integer userId) throws Exception {
		List<String> collections;
		try {
			collections = poeTradeDAO.getCollections(userId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}
		return collections;
	}
	
	@Override
	public Integer addCollection(Collection collection) throws Exception {
		Integer returnInteger;
		try {
			returnInteger = poeTradeDAO.addCollection(collection);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}
		return returnInteger;
	}
}
