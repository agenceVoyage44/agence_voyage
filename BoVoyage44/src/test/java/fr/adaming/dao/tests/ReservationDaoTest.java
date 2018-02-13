package fr.adaming.dao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import fr.adaming.model.Assurance;
import fr.adaming.model.Participant;
import fr.adaming.model.Reservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ReservationDaoTest {

	@Autowired
	IReservationDao reservationDao;

	Reservation reservation = new Reservation("en cours", 200d, null, 100);

	// --------------- Test GetAll Reservation ------------
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAll() {

		assertNotNull(reservationDao.getAllReservation());

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

	// ---------------- Test Modifer Reservation ---------------
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void updateReservationTest() {

		reservationDao.addReservation(reservation);

		reservation.setNbPlaceReservees(200);
		Reservation rOut = reservationDao.updateReservation(reservation);

		assertEquals(200, rOut.getNbPlaceReservees());

	}

	// ------------------Test Supprimer Reservation ---------------
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void testDelete() {
		reservationDao.addReservation(reservation);
		int tailleAvant = reservationDao.getAllReservation().size();
		reservationDao.deleteReservation(reservation.getId());
		assertEquals(tailleAvant - 1, reservationDao.getAllReservation().size());
	}

	// -------------------Test Rechercher une Reservation -----------
	@Ignore
	@Test
	@Transactional
	public void testGet() {
		reservationDao.addReservation(reservation);
		assertNotNull(reservationDao.getReservationByID(reservation.getId()));
	}

	@Ignore
	@Test
	@Transactional
	public void testGet2() {
		reservationDao.addReservation(reservation);
		Reservation rOut = reservationDao.getReservationByID(reservation.getId());
		assertEquals(100, rOut.getNbPlaceReservees());
	}

}
