package fr.adaming.dao.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IParticipantsDao;
import fr.adaming.model.Participant;
import fr.adaming.model.Reservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ParticipantDaoTest {

	@Autowired
	IParticipantsDao participantDao;

	Participant p;
	Participant p2;

	@Ignore
	@Before
	public void setUp() {
		p = new Participant("TOTO", "Titi", 1236547896, "M", 3, "rue des chenes", 44000, "Nantes", "France",
				new Date(1996 - 04 - 18));
		p2 = new Participant("FOUFOU", "Titi", 1236547896, "M", 3, "rue des chenes", 44000, "Nantes", "France",
				new Date(1996 - 04 - 18));
	}

	// #######TEST AJOUT ET GET ALL PARTICIPANTS##################
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void addParticipantTest() {

		int tailleAvant = participantDao.getAllParticipant().size();
		participantDao.addParticipant(p);
		// assertEquals("TOTO", participantDao.getParticipantById(1).getNom());
		assertEquals(tailleAvant + 1, participantDao.getAllParticipant().size());
	}

	// // ########TEST UPDATE ET GET BY ID PARTICIPANTS#############
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void UpdateParticipantTest() {
		participantDao.addParticipant(p);
		p.setNom("RORO");
		participantDao.updateParticipant(p);
		assertEquals(p, participantDao.getParticipantById(p.getId()));
	}

	// #########TEST DELETE PARTICIPANTS############################
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void deleteParticipantTest() {
		int tailleAvant = participantDao.getAllParticipant().size();
		participantDao.addParticipant(p);
		participantDao.deleteParticipant(p.getId());
		assertEquals(tailleAvant, participantDao.getAllParticipant().size());
	}

	// ###########TEST getParticipantsByReservation#############
	// @Test
	// @Transactional
	// @Rollback(true)
	// public void getParticipantsByReservationTest() {
	//
	// System.out.println("##########");
	// //p.setReservation(new Reservation(1, "aaa", 123, new Date(1996 - 05 -
	// 18), 15));
	// System.out.println(p);
	// participantDao.addParticipant(p);
	// assertEquals(p.getNom(),
	// participantDao.getParticipantById(p.getId()).getNom());
	// }

	// ###########TEST getParticipantsByReservatio NULLn#############
	@Ignore
	@Test
	@Transactional
	public void getParticipantsByReservationNullTest() {

		int tailleAvant = participantDao.getAllParticpantIDResaNULL().size();

		participantDao.addParticipant(p);
		participantDao.addParticipant(p2);
		assertEquals(tailleAvant + 2, participantDao.getAllParticpantIDResaNULL().size());
		// assertEquals(p2.getNom(),
		// participantDao.getParticipantById(p2.getId()).getNom());

	}
}
