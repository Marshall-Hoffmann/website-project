package marshall.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marshall.project.dao.DeathDAO;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeathServiceImpl implements DeathService{

	@Autowired
	DeathDAO deathDAO;
}
