package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormuleDao;
import fr.adaming.model.Formule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class FormuleDaoTest {

	@Autowired
	IFormuleDao formuleDao;

	Formule f;

	@Before
	public void setUp(){
		f=new Formule(4, "Avion+Hôtel", 150);
	}
	
	// ########## TEST GET ALL FORMULE ##########
	
	@Test
	@Transactional(readOnly=true)
	public void getAllFormuleTest(){
		assertEquals(3, formuleDao.getAllFormule().size());
	}
	

	// ########## TEST AJOUT FORMULE ##########

	@Test
	@Transactional
	@Rollback(true)
	public void addFormuleTest(){
		
		int tailleAvant=formuleDao.getAllFormule().size();
		formuleDao.addFormule(f);
		
		assertEquals(tailleAvant+1, formuleDao.getAllFormule().size());
	}
	
}
