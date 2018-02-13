package fr.adaming.dao.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHebergementDao;
import fr.adaming.model.Hebergement;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class HebergementDaoTest {

	@Autowired
	IHebergementDao hebergementDao;
	
	private Hebergement h=new Hebergement("hotel", 500);
	
	//------Test pour avoir la liste des hebergements-----
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testAllHebergement(){
		
		List<Hebergement> liste=new ArrayList<Hebergement>();
		liste=hebergementDao.getAllHebergement();
		assertNotNull(liste);
	}
	
	//------Test pour ajouter un Hebergement-------
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testaddHebergement() {
	
	int tailleAvant = hebergementDao.getAllHebergement().size();
	hebergementDao.addHebergement(h);
	assertEquals(tailleAvant+1, hebergementDao.getAllHebergement().size());
	}
	
	//-------Test Supprimer Hebergement--------
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testDeleteHebergement(){
		Hebergement htest = new Hebergement(5, "cabane", 350);
		int tailleAvant = hebergementDao.getAllHebergement().size();
		 hebergementDao.addHebergement(htest);
		 hebergementDao.deleteHebergement(5);
		 assertEquals(tailleAvant-1, hebergementDao.getAllHebergement().size());
		 }
	
	// ---------------- Test Modifer Hebergement ---------------
		@Ignore
		@Test
		@Transactional
		@Rollback(true)
		public void updateHebergementTest() {

			hebergementDao.addHebergement(h);

			h.setPrix(900);
			Hebergement hOut = hebergementDao.updateHebergement(h);

			assertEquals(900, hOut.getPrix());

		}
		
		//------Test pour rechercher un hebergement par id-------
		@Ignore
		@Test
		@Transactional(readOnly = true)
		public void testGetHebergement(){
			Hebergement htest = new Hebergement(5, "cabane", 350);
		assertNotNull(hebergementDao.getHebergementByID(htest.getId()));
		}
	

}
