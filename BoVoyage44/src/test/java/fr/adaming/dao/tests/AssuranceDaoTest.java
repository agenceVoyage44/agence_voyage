package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
	Assurance a1 =new Assurance(4,"annulation", 20);
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAll(){
		
		assertNotNull(assuranceDao.getAllAssurance());
		
	}
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testAdd(){
		int tailleAvant=assuranceDao.getAllAssurance().size();
		assuranceDao.addAssurance(a);
		
		assertEquals(tailleAvant+1, assuranceDao.getAllAssurance().size());
	}
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testUpdate(){
		a.setId(1);
		a.setPrix(40);
		assuranceDao.updateAssurance(a);
		assertEquals(40,0, a.getPrix());
	}
	
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testDelete(){
		int tailleAvant=assuranceDao.getAllAssurance().size();		
		assuranceDao.deleteAssurance(a1.getId());
		assertEquals(tailleAvant-1, assuranceDao.getAllAssurance().size());
	}
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGet(){
		assertNotNull(assuranceDao.getAssuranceById(a1.getId()));
	}
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGet2(){
		Assurance aOut=assuranceDao.getAssuranceById(a1.getId());
		assertEquals("annulation", aOut.getType() );
	}
}
