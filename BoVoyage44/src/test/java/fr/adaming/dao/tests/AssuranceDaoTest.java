package fr.adaming.dao.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAssuranceDao;
import fr.adaming.model.Assurance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class AssuranceDaoTest {
	
	@Autowired
	IAssuranceDao assuranceDao;
	
	Assurance a =new Assurance("annulation", 20);
	@Test
	@Transactional(readOnly = true)
	public void testGetAll(){
		
		assertNotNull(assuranceDao.getAllAssurance());
		
	}
	
	
}
