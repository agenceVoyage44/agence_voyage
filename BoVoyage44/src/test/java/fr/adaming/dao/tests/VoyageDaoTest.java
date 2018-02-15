// package fr.adaming.dao.tests;
//
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
//
// import java.util.List;
//
// import org.junit.Ignore;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.annotation.Rollback;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.transaction.annotation.Transactional;
//
// import fr.adaming.dao.IVoyageDao;
// import fr.adaming.model.Voyage;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = {
// "file:src/main/webapp/WEB-INF/application-context.xml" })
// public class VoyageDaoTest {
//
// @Autowired
// private IVoyageDao voyageDao;
//
// private Voyage v = new Voyage("poutre", "brique", 5, 7, 10, null, null, null,
// 7, true, "haha", "maybe this time",
// true);
//
// @Ignore
// @Test
// @Rollback(true)
// @Transactional
// public void testAddVoyage() {
// v = voyageDao.addVoyage(v);
//
// assertNotNull(v.getId());
// }
//
// @Ignore
// @Test
// @Transactional(readOnly = true)
// public void testGetAllVoyage() {
// assertEquals(2, voyageDao.getAllVoyage().size());
// }
//
// @Ignore
// @Test
// @Transactional(readOnly = true)
// public void testGetVoyageById() {
// assertEquals("pik", voyageDao.getVoyageById(2).getContinent());
// }
//
// @Ignore
// @Test
// @Rollback(true)
// @Transactional
// public void testUpdateVoyage() {
// v.setId(2);
// voyageDao.updateVoyage(v);
// Voyage vOut = voyageDao.getVoyageById(2);
// assertEquals(vOut.getContinent(), v.getContinent());
// }
//
// @Ignore
// @Test
// @Rollback(true)
// @Transactional
// public void testDeleteVoyage() {
// voyageDao.deleteVoyage(2);
// assertEquals(1, voyageDao.getAllVoyage().size());
// }
//
// }
