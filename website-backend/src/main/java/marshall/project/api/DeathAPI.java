package marshall.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import marshall.project.service.DeathService;

@RestController
@CrossOrigin
public class DeathAPI {
	
	@Autowired
	DeathService deathService;

}
