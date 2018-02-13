package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Participant;

/**
 * @author inti-0257 Interface IparticipantService définissant les méthodes
 *         service de la classe Participant
 *
 */
public interface IParticipantService {

	public List<Participant> getAllParticipant();

	public List<Participant> getParticipantsByReservation(int idRes);

	public Participant addParticipant(Participant p);

	public Participant updateParticipant(Participant p);

	public int deleteParticipant(int id);

	public Participant getParticipantById(int id);

}
