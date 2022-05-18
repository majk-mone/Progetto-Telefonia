package telefonia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonia.model.ChiamateModel;
import telefonia.repository.ChiamateRepository;

@Service
public class ChiamateService {

	@Autowired
	ChiamateRepository chiamateRepository;

	public ChiamateModel inserisciChiamata(ChiamateModel c) {
		c.setDurata(c.calcoloDurata());
		return chiamateRepository.save(c);

	}

	public ChiamateModel updateChiamate(Integer id, ChiamateModel c) {
		ChiamateModel chiamataDaAggiornare = chiamateRepository.getById(id);
		chiamataDaAggiornare.setIdUtente(c.getIdUtente());
		chiamataDaAggiornare.setDataInizio(c.getDataInizio());
		chiamataDaAggiornare.setDataFine(c.getDataFine());
		chiamataDaAggiornare.setDurata(c.calcoloDurata());
		return chiamateRepository.save(chiamataDaAggiornare);

	}

	public void eliminaChiamata(Integer id) {
		chiamateRepository.deleteById(id);
	}

//public Long calcoloDurataChiamata(Integer id, Date dateStart, Date dateEnd) {
//		
//		
//		return chiamateRepository.sommaDurate(id, dateStart, dateEnd);
//	}
}
