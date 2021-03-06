package telefonia.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telefonia.model.ChiamateModel;
import telefonia.repository.ChiamateRepository;
import telefonia.service.ChiamateService;

@RestController
public class ChiamataController {

    @Autowired
    ChiamateService chiamateService;

    @Autowired
    ChiamateRepository chiamateRepository;

    @GetMapping("/chiamate")
    public Iterable<ChiamateModel> vediChiamate() {
	return chiamateRepository.findAll();
    }

    @PostMapping("/chiamate")
    public ChiamateModel inserisciChiamata(@RequestBody ChiamateModel c) {
	return chiamateService.inserisciChiamata(c);
    }

    @PutMapping(value = "/chiamata/{idChiamata}")
    public ChiamateModel modificaChiamata(@PathVariable("idChiamata") Integer idChiamata,
	    @RequestBody ChiamateModel c) {
	return chiamateService.updateChiamate(idChiamata, c);
    }

    @DeleteMapping("chiamata/{idChiamata}")
    public void cancellaChiamata(@PathVariable("idChiamata") Integer idChiamata) {
	chiamateService.eliminaChiamata(idChiamata);
    }

    @GetMapping("/reportChiamate/{dateStart}/{dateEnd}")
    public Long reportChiamate(
	    @PathVariable("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dateStart,
	    @PathVariable("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dateEnd) {
	return chiamateService.calcoloDurataChiamata(dateStart, dateEnd);
    }

}
