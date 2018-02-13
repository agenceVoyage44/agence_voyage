package fr.adaming.dao.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IParticipantsDao;
import fr.adaming.model.Participant;
import fr.adaming.service.IParticipantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ParticipantDaoTest {
	
	@Autowired
	IParticipantsDao participantDao;
	
Participant p;

	@Before
	public void setUp() {
	p=new Participant(1, "TOTO", "Titi", 1236547896, "M", 3, "rue des chenes", 44000,"Nantes", "France", new Date(1996-04-18));
	}
	
	//#######TEST AJOUT PARTICIPANT##################
	@Test
	@Transactional
	@Rollback(true)
	public void addParticipantTest() {

		int tailleAvant = participantDao.getAllParticipant().size();
		participantDao.addParticipant(p);
		assertEquals(tailleAvant + 1, participantDao.getAllParticipant().size());
	}
	
//	// ########TEST GET ALL PARTICIPANTS#############
//		@Transactional(readOnly = true)
//		@Test
//		public void getAllCargATest() {
//			assertEquals(3, transportService.getAllCargaisonsA().size());
//		}

}
