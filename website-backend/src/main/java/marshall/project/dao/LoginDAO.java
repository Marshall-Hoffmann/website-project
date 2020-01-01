package marshall.project.dao;

import marshall.project.model.User;

public interface LoginDAO {
	
	public User login(User credentials) throws Exception;
	
	public User signup(User credentials) throws Exception;

}
