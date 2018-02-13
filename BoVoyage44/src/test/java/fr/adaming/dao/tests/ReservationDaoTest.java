package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;

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

import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Participant;
import fr.adaming.model.Reservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ReservationDaoTest {

	@Autowired
	IReservationDao reservationDao;

	private Reservation reservation;

	@Ignore
	@Before
	public void setUp() {
		reservation = new Reservation(1, "en cours", 200d, null, 100);
	}

	// ---------------- Test Ajouter Reservation ---------------
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void addReservationTest() {

		int tailleAvant = reservationDao.getAllReservation().size();
		reservationDao.addReservation(reservation);
		assertEquals(tailleAvant + 1, reservationDao.getAllReservation().size());

	}

}
