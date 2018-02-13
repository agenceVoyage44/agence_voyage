package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IParticipantsDao;
import fr.adaming.model.Participant;

@Service
@Transactional
public class ParticipantServiceImpl implements IParticipantService {

	@Autowired
	private IParticipantsDao participantDao;

	@Override
	public List<Participant> getAllParticipant() {

		return participantDao.getAllParticipant();
	}

	@Override
	public List<Participant> getParticipantsByReservation(int idRes) {
		return participantDao.getParticipantsByReservation(idRes);

	}

	@Override
	public Participant addParticipant(Participant p) {
		return participantDao.addParticipant(p);

	}

	@Override
	public Participant updateParticipant(Participant p) {
		return participantDao.updateParticipant(p);

	}

	@Override
	public int deleteParticipant(int id) {
		return participantDao.deleteParticipant(id);

	}

	@Override
	public Participant getParticipantById(int id) {

		return participantDao.getParticipantById(id);
	}

}
