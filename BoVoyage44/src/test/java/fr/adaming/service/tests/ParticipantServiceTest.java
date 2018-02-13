package fr.adaming.service.tests;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Participant;
import fr.adaming.service.IParticipantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ParticipantServiceTest {
	
	@Autowired
	IParticipantService participantService;
	
Participant p;

	@Before
	public void setUp() {
	p=new Participant(1, "TOTO", "Titi", 1236547896, "M", 3, "rue des chenes", 44000,"Nantes", "France", new Date(1996-04-18));
	}
	
	//#######TEST AJOUT PARTICIPANT##################
	@Test
	@Transactional
	@Rollback(true)
	public void addCargATest() {

		int tailleAvant = participantService.getAllParticipant().size();
		participantService.addParticipant(p);
		assertEquals(tailleAvant + 1, participantService.getAllParticipant().size());
	}
	
	// ########TEST GET ALL PARTICIPANTS#############
		@Transactional(readOnly = true)
		@Test
		public void getAllCargATest() {
			assertEquals(3, transportService.getAllCargaisonsA().size());
		}

}
