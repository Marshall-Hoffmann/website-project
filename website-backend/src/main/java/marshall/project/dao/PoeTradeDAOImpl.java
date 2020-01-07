package marshall.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import marshall.project.entity.CollectionEntity;
import marshall.project.entity.LeagueEntity;
import marshall.project.entity.SearchCollectionEntity;
import marshall.project.entity.TradeItemEntity;
import marshall.project.entity.UserEntity;
import marshall.project.model.Collection;
import marshall.project.model.TradeItem;

@Repository
public class PoeTradeDAOImpl implements PoeTradeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addTradeItem(TradeItem tradeItem) throws Exception {
		TradeItemEntity tradeItemEntity = new TradeItemEntity();
		SearchCollectionEntity searchCollectionEntity = new SearchCollectionEntity();
		try {
			tradeItemEntity.setDescription(tradeItem.getDescription());
			tradeItemEntity.setName(tradeItem.getName());
			tradeItemEntity.setPriceHistoryUrl(tradeItem.getPriceHistoryUrl());
			tradeItemEntity.setTradeUrl(tradeItem.getTradeUrl());
			entityManager.persist(tradeItemEntity);
			
			searchCollectionEntity.setTradeItemEntity(tradeItemEntity);
			
			String jpqlString = "select c.collectionId from CollectionEntity c where c.collectionName = :colName";
			Query query = entityManager.createQuery(jpqlString);
			query.setParameter("colName", tradeItem.getCollectionName());
			CollectionEntity collectionEntity = entityManager.find(CollectionEntity.class, query.getSingleResult());
			searchCollectionEntity.setCollectionEntity(collectionEntity);
			searchCollectionEntity.setUserEntity(entityManager.find(UserEntity.class, tradeItem.getUserId()));
			
			jpqlString = "select l.leagueId from LeagueEntity l where l.leagueName = :leagueName";
			Query query2 = entityManager.createQuery(jpqlString);
			query2.setParameter("leagueName", tradeItem.getLeagueName());
			searchCollectionEntity.setLeagueEntity(entityManager.find(LeagueEntity.class, query2.getSingleResult()));
			
			entityManager.persist(searchCollectionEntity);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return searchCollectionEntity.getSearchCollectionId();
		
	}
	
	public Integer deleteTradeItem(Integer itemId) throws Exception {
		try {
			System.out.println("here: " + itemId);
			SearchCollectionEntity searchCollectionEntity = entityManager.find(SearchCollectionEntity.class, itemId);
			
			searchCollectionEntity.setCollectionEntity(null);
			searchCollectionEntity.setLeagueEntity(null);
			searchCollectionEntity.setTradeItemEntity(null);
			searchCollectionEntity.setUserEntity(null);
			
			entityManager.remove(searchCollectionEntity);
			
			return itemId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<TradeItem> getTradeItems(Integer userId) throws Exception {
		
		try {
			String jpqlString = "select s.searchCollectionId, s.collectionEntity.collectionId, s.tradeItemEntity.itemId, s.leagueEntity.leagueId, s.userEntity.userId from SearchCollectionEntity s where s.userEntity.userId = :userId";
			Query query = entityManager.createQuery(jpqlString);
			query.setParameter("userId", userId);
			List<Object[]> searchCollectionList = query.getResultList();
			
			List<TradeItem> returnList = new ArrayList<TradeItem>();
			if(searchCollectionList != null) {
				for(Object[] sl:searchCollectionList) {
					TradeItem tradeItem = new TradeItem();
					
					CollectionEntity collectionEntity = entityManager.find(CollectionEntity.class, sl[1]);
					tradeItem.setCollectionName(collectionEntity.getCollectionName());
					
					TradeItemEntity tradeItemEntity = entityManager.find(TradeItemEntity.class, sl[2]);
					tradeItem.setDescription(tradeItemEntity.getDescription());
					
					tradeItem.setItemId((Integer)sl[0]);
					tradeItem.setName(tradeItemEntity.getName());
					tradeItem.setPriceHistoryUrl(tradeItemEntity.getPriceHistoryUrl());
					tradeItem.setTradeUrl(tradeItemEntity.getTradeUrl());
					
					LeagueEntity leagueEntity = entityManager.find(LeagueEntity.class, sl[3]);
					tradeItem.setLeagueName(leagueEntity.getLeagueName());
					
					UserEntity userEntity = entityManager.find(UserEntity.class, sl[4]);
					tradeItem.setUserId(userEntity.getUserId());
					
					returnList.add(tradeItem);
				}
			}

			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			List<TradeItem> emptyList = null;
			return emptyList;
		}
	}
	
	public List<String> getCollections(Integer userId) throws Exception {
		try {
			String jpqlString = "select c.collectionName from CollectionEntity c where c.userEntity.userId = :userId";
			Query query = entityManager.createQuery(jpqlString);
			query.setParameter("userId", userId);
			List<String> collectionNames = query.getResultList();
			List<String> returnCollectionNames = new ArrayList<String>();
			if(collectionNames != null) {
				for(String c:collectionNames) {
					returnCollectionNames.add(c);
				}
			}
			return returnCollectionNames;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			List<String> emptyList = null;
			return emptyList;
		}
	}
	
	public Integer addCollection(Collection collection) throws Exception {
		CollectionEntity collectionEntity = new CollectionEntity();
		Integer collectionId;
		try {
			collectionEntity.setCollectionName(collection.getCollectionName());
			collectionEntity.setUserEntity(entityManager.find(UserEntity.class, collection.getCollectionUserId()));
			entityManager.persist(collectionEntity);
			collectionId = collectionEntity.getCollectionId();
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
		return collectionId;
	}
}
