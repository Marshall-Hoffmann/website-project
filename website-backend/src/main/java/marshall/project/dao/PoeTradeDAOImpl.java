package marshall.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import marshall.project.entity.TradeItemEntity;
import marshall.project.model.TradeItem;

@Repository
public class PoeTradeDAOImpl implements PoeTradeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addTradeItem(TradeItem tradeItem) throws Exception {
		TradeItemEntity tradeItemEntity = new TradeItemEntity();
		try {
//			TradeItemEntity tradeItemEntity = new TradeItemEntity();
			tradeItemEntity.setDescription(tradeItem.getDescription());
			tradeItemEntity.setName(tradeItem.getName());
			tradeItemEntity.setPriceHistoryUrl(tradeItem.getPriceHistoryUrl());
			tradeItemEntity.setTradeUrl(tradeItem.getTradeUrl());
			entityManager.persist(tradeItemEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return tradeItemEntity.getItemId();
		
	}
	
	public Integer deleteTradeItem(Integer itemId) throws Exception {
		try {
			TradeItemEntity tradeItemEntity = entityManager.find(TradeItemEntity.class, itemId);
			entityManager.remove(tradeItemEntity);
			return itemId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<TradeItem> getTradeItems() throws Exception {
		
		try {
			String jpqlString = "select t.itemId, t.name, t.description, t.tradeUrl, t.priceHistoryUrl from TradeItemEntity t";
			System.out.println("made it here");
			Query query = entityManager.createQuery(jpqlString);
			List<Object[]> tradeItemEntityList = query.getResultList();
			List<TradeItem> tradeItems = new ArrayList<TradeItem>();
			if(tradeItemEntityList != null) {
				System.out.println("made it here again: " + tradeItemEntityList);
				for(Object[] te: tradeItemEntityList) {
					System.out.println("1: " + te[0] + " dfdfdf " + te[1]);
					TradeItem tradeItem = new TradeItem();
					
					tradeItem.setTradeId((Integer) te[0]);
					tradeItem.setDescription((String) te[2]);
					tradeItem.setName((String) te[1]);
					tradeItem.setPriceHistoryUrl((String) te[4]);
					tradeItem.setTradeUrl((String)te[3]);
//					System.out.println(tradeItem);
					tradeItems.add(tradeItem);
				}
			}
			System.out.println(tradeItems);
			return tradeItems;
		} catch (Exception e) {
			e.printStackTrace();
			List<TradeItem> emptyList = null;
			return emptyList;
		}
	}
}
