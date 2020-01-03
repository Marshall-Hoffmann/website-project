package marshall.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import marshall.project.entity.TradeItemEntity;
import marshall.project.entity.UserEntity;
import marshall.project.model.TradeItem;

@Repository
public class PoeTradeDAOImpl implements PoeTradeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addTradeItem(TradeItem tradeItem) throws Exception {
		TradeItemEntity tradeItemEntity = new TradeItemEntity();
		try {
			tradeItemEntity.setDescription(tradeItem.getDescription());
			tradeItemEntity.setName(tradeItem.getName());
			tradeItemEntity.setPriceHistoryUrl(tradeItem.getPriceHistoryUrl());
			tradeItemEntity.setTradeUrl(tradeItem.getTradeUrl());
			UserEntity userEntity = entityManager.find(UserEntity.class, tradeItem.getEmailId());
			tradeItemEntity.setUserEntity(userEntity);
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
			tradeItemEntity.setUserEntity(null);
			entityManager.remove(tradeItemEntity);
			return itemId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<TradeItem> getTradeItems(String emailId) throws Exception {
		
		try {
			List<TradeItem> fullList = getAllTradeItems();
			List<TradeItem> filteredList = fullList.stream().filter(x -> x.getEmailId().equals(emailId)).collect(Collectors.toList());
			return filteredList;
		} catch (Exception e) {
			e.printStackTrace();
			List<TradeItem> emptyList = null;
			return emptyList;
		}
	}
	
	public List<TradeItem> getAllTradeItems() throws Exception {
		try {
			String jpqlString = "select t.itemId, t.name, t.description, t.tradeUrl, t.priceHistoryUrl, t.userEntity.email from TradeItemEntity t";
			Query query = entityManager.createQuery(jpqlString);
			List<Object[]> tradeItemEntityList = query.getResultList();
			List<TradeItem> tradeItems = new ArrayList<TradeItem>();
			if(tradeItemEntityList != null) {
				for(Object[] te: tradeItemEntityList) {
					TradeItem tradeItem = new TradeItem();
					tradeItem.setItemId((Integer) te[0]);
					tradeItem.setDescription((String) te[2]);
					tradeItem.setName((String) te[1]);
					tradeItem.setPriceHistoryUrl((String) te[4]);
					tradeItem.setTradeUrl((String)te[3]);
					tradeItem.setEmailId((String)te[5]);
					tradeItems.add(tradeItem);
				}
			}
			return tradeItems;
		} catch (Exception e) {
			e.printStackTrace();
			List<TradeItem> emptyList = null;
			return emptyList;
		}
	}
}
