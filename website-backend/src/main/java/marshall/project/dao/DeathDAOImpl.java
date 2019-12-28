package marshall.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DeathDAOImpl implements DeathDAO {

	@PersistenceContext
	private EntityManager entityManager;
}
