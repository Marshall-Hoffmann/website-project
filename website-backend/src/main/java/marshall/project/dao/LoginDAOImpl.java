package marshall.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import marshall.project.entity.UserEntity;
import marshall.project.model.User;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User login(User credentials) throws Exception {
		User returnUser = new User();
		try {
			String jqplString = "select u.userId from UserEntity u where u.email = :email";
			Query query = entityManager.createQuery(jqplString);
			query.setParameter("email", credentials.getEmail());
			UserEntity userEntity = entityManager.find(UserEntity.class, query.getSingleResult());
			
			returnUser.setEmail(userEntity.getEmail());
			returnUser.setName(userEntity.getName());
			returnUser.setPassword(userEntity.getPassword());
			returnUser.setUserId(userEntity.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return returnUser;
	}
	
	public User signup(User credentials) throws Exception {
		UserEntity userEntity = new UserEntity();
		User returnUser = new User();
		try {
			userEntity.setEmail(credentials.getEmail());
			userEntity.setName(credentials.getName());
			userEntity.setPassword(credentials.getPassword());
			entityManager.persist(userEntity);
			
			returnUser.setEmail(credentials.getEmail());
			returnUser.setName(credentials.getName());
			returnUser.setPassword(credentials.getPassword());
			returnUser.setUserId(userEntity.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return returnUser;
	}
}
