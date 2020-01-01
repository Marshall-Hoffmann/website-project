package marshall.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marshall.project.dao.LoginDAO;
import marshall.project.model.User;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public User login(User credentials) throws Exception {
		User user = new User();
		try {
			user = loginDAO.login(credentials);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return user;
	}
	
	@Override
	public User signup(User credentials) throws Exception {
		User user = new User();
		try {
			user = loginDAO.signup(credentials);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return user;
	}

}
