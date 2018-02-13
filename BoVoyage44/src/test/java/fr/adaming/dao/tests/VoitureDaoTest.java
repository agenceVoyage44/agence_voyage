package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class VoitureDaoTest {

	@Autowired
	private IVoitureDao voitureDao;
	Voiture v;

	@Before
	public void init() {
		v = new Voiture("4x4", "LocCompany", 4, null);
	}

	// ******** Test GetAll ********
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAllVoiture() {
		// Une voiture a été créer manuelement avec l'id=1
		assertEquals(1, voitureDao.getAllVoiture().size());
	}

	// ******** Test Ajouter ********
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddVoiture() {
		int tailleInit = voitureDao.getAllVoiture().size();
		voitureDao.addVoiture(v);
		assertEquals(tailleInit + 1, voitureDao.getAllVoiture().size());
	}

	// ******** Test GetById ********
	@Ignore
	@Test
	@Transactional(readOnly = true)
	@Rollback(true)
	public void testGetVoitureById() {
		Voiture v2 = voitureDao.getVoitureById(1);
		assertNotNull(v2);
	}

	// ******** Test Supprimer ********
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteVoiture() {
		int tailleInit = voitureDao.getAllVoiture().size();
		voitureDao.deleteVoiture(1);
		assertEquals(tailleInit - 1, voitureDao.getAllVoiture().size());
	}

	// ******** Test Update ********
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateVoiture() {
		Voiture v1 = new Voiture(1,"mod", "company", 3, null);
		
		Voiture v2 = voitureDao.updateVoiture(v1);
		
		assertTrue(v1.getLoueur() == v2.getLoueur() & v1.getModele()==v2.getModele() & v1.getNbPlaces() == v2.getNbPlaces());
	}
	
	

}
