package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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
	Formule f1;

	@Before
	public void setUp(){
		f=new Formule("Avion+Hôtel", 150);
	}
	
	// ########## TEST GET ALL FORMULE ##########
	
	@Ignore
	@Test
	@Transactional(readOnly=true)
	public void getAllFormuleTest(){
		// 1 Formule ajoutée manuellement dans la BDD pour les tests
		assertEquals(1, formuleDao.getAllFormule().size());
	}
	

	// ########## TEST AJOUT FORMULE ##########

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void addFormuleTest(){
		
		int tailleAvant=formuleDao.getAllFormule().size();
		formuleDao.addFormule(f);
		
		assertEquals(tailleAvant+1, formuleDao.getAllFormule().size());
	}
	
	// ########## TEST GET FORMULE BY ID ##########
	
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void getFormuleTest() {
		Formule formule=formuleDao.getFormuleById(1);
		assertEquals(formule.getId(), 1);
	}
	
	// ########## TEST DELETE FORMULE ##########
	
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void deleteFormuleTest() {
		int tailleAvant=formuleDao.getAllFormule().size();
		formuleDao.deleteFormule(1);
		
		assertEquals(tailleAvant-1, formuleDao.getAllFormule().size());
	}
	
	// ########## TEST MODIFIER FORMULE ##########

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void updateFormuleTest(){
		
		f1=new Formule(1, "Avion+Voiture", 300);
		Formule f2=formuleDao.updateFormule(f1);
		
		assertTrue(f1.getPrix()==f2.getPrix()&f1.getType()==f2.getType());
	}
	
}
