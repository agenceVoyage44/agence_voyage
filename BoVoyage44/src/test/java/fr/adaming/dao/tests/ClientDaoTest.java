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

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class ClientDaoTest {
	@Autowired
	IClientDao clientDao;
	
	Client c=new Client("TOTO", "titi", 22, "Mr", 23, "rue crebillon", 44000, "Nantes", "France", null, 2, "c@c", "c");
	Client c1=new Client(9,"TOTO", "titi", 22, "Mr", 23, "rue crebillon", 44000, "Nantes", "France", null, 2, "c@c", "c");
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAll(){
		
		assertNotNull(clientDao.getAllClient());
	}
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testAdd(){
		
		int tailleAvant=clientDao.getAllClient().size();
		
		clientDao.addClient(c);
		
		assertEquals(tailleAvant+1,clientDao.getAllClient().size());
	}
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testDelete(){
		
		clientDao.addClient(c);		
		int tailleAvant=clientDao.getAllClient().size();
		int verif=clientDao.deleteClient(c.getId());
		assertEquals(tailleAvant-1, clientDao.getAllClient().size());
	}
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testUpdate(){
		c.setNom("FOFO");
		clientDao.updateClient(c);
		assertEquals("FOFO", c.getNom());
	}
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGet(){
		
		
		
		Client cOut=clientDao.getClientById(c1.getId());
		
		assertNotNull(cOut);
		
	}
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGet2(){
			
		
		Client cOut=clientDao.getClientById(c1.getId());
		
		assertEquals("TOTO", cOut.getNom());
		
	}
}

