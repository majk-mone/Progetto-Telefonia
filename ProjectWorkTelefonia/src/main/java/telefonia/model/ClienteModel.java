package telefonia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "codice_fiscale")
	private String codFiscale;
	@Column(name = "numero")
	private Long numero;
	@Column(name = "stato_linea")
	private String statoLinea;
	@Column(name = "tipo_linea")
	private String tipoLinea;

	public ClienteModel(String nome, String cognome, String codFiscale, Long numero, String statoLinea,
			String tipoLinea) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
		this.numero = numero;
		this.statoLinea = statoLinea;
		this.tipoLinea = tipoLinea;
	}

}
