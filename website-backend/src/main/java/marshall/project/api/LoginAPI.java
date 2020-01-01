package marshall.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import marshall.project.model.User;
import marshall.project.service.LoginService;

@RestController
@CrossOrigin
public class LoginAPI {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login/", method=RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User credentials) {
		System.out.println("hello" + credentials.getName());
		System.out.println("hello2" + credentials.getPassword());
		try {
			User user = loginService.login(credentials);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/signup/", method=RequestMethod.POST)
	public ResponseEntity<User> signup(@RequestBody User credentials) {
		System.out.println("hello" + credentials.getName());
		System.out.println("hello2" + credentials.getPassword());
		try {
			User user = loginService.signup(credentials);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
}
