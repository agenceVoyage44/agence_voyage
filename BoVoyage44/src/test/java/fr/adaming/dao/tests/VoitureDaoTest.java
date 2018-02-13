package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoitureDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class VoitureDaoTest {

	@Autowired
	private IVoitureDao voitureDao;

	// ******** Test GetAll ********
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAllEtudiant() {
		assertEquals(1, voitureDao.getAllVoiture().size());
	}

	
	
}
