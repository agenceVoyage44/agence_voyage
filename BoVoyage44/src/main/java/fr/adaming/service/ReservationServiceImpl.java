package fr.adaming.service;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.mail.smtp.SMTPTransport;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IParticipantsDao;
import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Client;
import fr.adaming.model.Participant;
import fr.adaming.model.Reservation;

/**
 * Classe de d�finition des m�thodes m�tiers des objets de type Reservation
 *
 */

@Transactional
@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;
	
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private IParticipantsDao participantDao;

	// Injection D�pendance
	public void setReservationDao(IReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	/**
	 * M�thode pour ajouter une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	@Override
	public Reservation addReservation(Reservation reservation) throws AddressException, MessagingException, MalformedURLException, IOException {
		reservationDao.addReservation(reservation);
		
		//envoi mail de confirmation
		
		//1. R�cup�rer le client ayant r�serv�
		Client cRes=clientDao.getClientByReservation(reservation.getId());
		//2. R�cup�rer les participants
		List<Participant> listePart=participantDao.getParticipantsByReservation(reservation.getId());
		
		//3. Pr�paration du pdf
		
		// cr�ation pdf
				
				Document document = new Document();
				//
				try {
					/* Associate the document with a PDF writer and an output stream */
					PdfWriter.getInstance(document,
							new FileOutputStream("C:\\Users\\inti-0257\\Desktop\\formation\\Agence_voyage\\Reservation_voyage_"+reservation.getId()+".pdf"));

					/* Open the document (ready to add items) */
					document.open();
					Font font = new Font(Font.HELVETICA, 14, Font.BOLD, Color.BLUE);
				
					Image image = Image.getInstance("/BoVoyage44/src/main/webapp/images/logo_agence.png");
			
					document.add(image);
					document.add(new Paragraph(" "));
					document.add(new Paragraph("N� de client : " + cRes.getId()));
					document.add(new Paragraph("Nom : " + cRes.getCivilite()+" "+cRes.getNom()+" "+cRes.getPrenom()));
					document.add(new Paragraph("E-mail : " + cRes.getMail()));
					document.add(new Paragraph("Adresse : " + cRes.getNumero()+" "+cRes.getRue()+" "+cRes.getCodePostal()+" "+cRes.getVille()+" "+cRes.getPays()));
					document.add(new Paragraph("N� de t�l�phone : " + cRes.getTel()));
					document.add(new Paragraph("Date de naissance : " + cRes.getDateNaissance()));
					document.add(new Paragraph("Date de la r�servation : " + reservation.getDateReservation()));

					document.add(new Paragraph(" "));

					Paragraph para = new Paragraph("Description de votre voyage : ", font);
					para.setAlignment(Element.ALIGN_CENTER);
					document.add(para);

					document.add(new Paragraph(" "));
					//
					//
					PdfPTable table = new PdfPTable(5);
					////
					//// //On cr�er l'objet cellule.
					PdfPCell cell;
					////
					Font font2 = new Font(Font.HELVETICA, 13, Font.BOLD, Color.BLACK);
					Phrase phrase = new Phrase("Liste des produits command�s", font2);

					cell = new PdfPCell(phrase);
					cell.setColspan(5);
					table.addCell(cell);
					//
					table.addCell("Destination");
					table.addCell("Nombre de places r�serv�es");
					table.addCell("Date de d�part");
					table.addCell("Date de retour");
					table.addCell("Prix");
					
					//
					table.addCell(reservation.getVoyage().getPays());
					table.addCell(Integer.toString(reservation.getNbPlaceReservees()));
					table.addCell(reservation.getVoyage().getDateDepart().toString());
					table.addCell(reservation.getVoyage().getDateRetour().toString());
					table.addCell(Double.toString(reservation.getPrix())+" �");
					
					document.add(table);
			
					
					
				
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));

					PdfPTable table2 = new PdfPTable(2);
					Phrase phrase2 = new Phrase("Vous partez avec :", font2);

					cell = new PdfPCell(phrase2);
					cell.setColspan(4);
					table.addCell(cell);
					//
					table.addCell("Nom");
					table.addCell("Date de naissance");
					table.addCell("Adresse");
					table.addCell("N� de t�l�phone");
					
					for (int i = 0; i < listePart.size(); i++) {
						table.addCell(listePart.get(i).getCivilite()+" "+listePart.get(i).getNom()+" "+listePart.get(i).getPrenom());
						table.addCell(listePart.get(i).getDateNaissance().toString());
						table.addCell(listePart.get(i).getNumero()+" "+listePart.get(i).getRue()+" "+listePart.get(i).getCodePostal()+" "+listePart.get(i).getVille());
						table.addCell(Integer.toString(listePart.get(i).getTel()));
						}
					
					document.add(table2);
					
					System.out.println("pdf cree");
				} catch (DocumentException e) {
				
					System.err.println(e);
				} finally {

					document.close();
			
				}
			

				// Envoi du mail contenant le pdf
				// System.out.println("############test mail#############");

				Properties props = System.getProperties();
				props.put("mail.smtps.host", "smtp.gmail.com");
				props.put("mail.smtps.auth", "true");
				Session session = Session.getInstance(props, null);
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("application.j2ee@gmail.com"));
				;
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cRes.getMail(), false));
				msg.setSubject("BoVoyage44 ");
				msg.setText("Votre r�servation est confirm�e.");
				msg.setSentDate(new Date());

				Multipart multipart = new MimeMultipart();
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				msg.setText("Votre r�servation est confirm�e.");
				msg.setText("R�servation effectu�e le "+ reservation.getDateReservation());
				msg.setText("Vous partez en  "+ reservation.getVoyage().getPays()+" du "+reservation.getVoyage().getDateDepart()+" au "+reservation.getVoyage().getDateRetour());
				msg.setText("L'�quipe de BoVoyage44 vous souhaite un agr�able s�jour!");
				multipart.addBodyPart(messageBodyPart);

				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource("C:\\Users\\inti-0257\\Desktop\\formation\\Agence_voyage\\Reservation_voyage_"+reservation.getId()+".pdf");
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName("reservation_"+reservation.getId()+".pdf");
				multipart.addBodyPart(messageBodyPart);
				msg.setContent(multipart);

				SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
				t.connect("smtp.gmail.com", "application.j2ee@gmail.com", "adamingintijee");
				t.sendMessage(msg, msg.getAllRecipients());
				System.out.println("Mail envoy�");
				t.close();
		
		
		
		return reservation;
	}

	/**
	 * M�thode pour modifier une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	@Override
	public Reservation updateReservation(Reservation reservation) {
		return reservationDao.updateReservation(reservation);
	}

	/**
	 * M�thode pour rechercher une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	@Override
	public Reservation getReservationByID(int idReservation) {
		return reservationDao.getReservationByID(idReservation);
	}

	/**
	 * M�thode pour supprimer une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	@Override
	public int deleteReservation(int idReservation) {
		return reservationDao.deleteReservation(idReservation);
	}

	/**
	 * M�thode pour cr�er une liste de reservations
	 * 
	 * @return List<Reservation>
	 */
	@Override
	public List<Reservation> getAllReservation() {
		return reservationDao.getAllReservation();
	}

}
