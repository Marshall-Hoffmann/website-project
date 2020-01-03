package marshall.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marshall.project.dao.PoeTradeDAO;
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
//		Integer itemId;
		try {
			itemId = poeTradeDAO.deleteTradeItem(itemId);
		} catch (Exception e){
			throw new Exception(e);
		}
		return itemId;
	}
	
	@Override
	public List<TradeItem> getTradeItems(String emailId) throws Exception {
		List<TradeItem> itemList;
		try {
			System.out.println("getId again: " + emailId);
			itemList = poeTradeDAO.getTradeItems(emailId); 
		} catch (Exception e) {
			throw new Exception(e);
		}
		return itemList;
	}
}
