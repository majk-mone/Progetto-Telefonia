package telefonia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "chiamate")
public class ChiamateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chiamata")
    private Integer idChiamata;

    @Column(name = "id_utente")
    private Integer idUtente;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @Column(name = "data_inizio")
    private Date dataInizio;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @Column(name = "data_fine")
    private Date dataFine;

    @Column(name = "durata")
    private Long durata;

    public Long calcoloDurata() {
	return (this.dataFine.getTime() - this.dataInizio.getTime()) / 1000;
    }

    public ChiamateModel(Integer idChiamata, Integer idUtente, Date dataInizio, Date dataFine, Long durata) {
	super();
	this.idChiamata = idChiamata;
	this.idUtente = idUtente;
	this.dataInizio = dataInizio;
	this.dataFine = dataFine;
	this.durata = durata;
    }

    public ChiamateModel(Integer idUtente, Date dataInizio, Date dataFine, Long durata) {
	super();
	this.idUtente = idUtente;
	this.dataInizio = dataInizio;
	this.dataFine = dataFine;
	this.durata = durata;
    }

    public ChiamateModel() {
	super();
    }

}
