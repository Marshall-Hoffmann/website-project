package marshall.project.service;

import marshall.project.model.User;

public interface LoginService {
	
	public User login(User credentials) throws Exception;
	
	public User signup(User credentials) throws Exception;

}
