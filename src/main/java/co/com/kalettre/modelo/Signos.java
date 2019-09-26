package co.com.kalettre.modelo;
// Generated 19/09/2019 01:37:33 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Signos generated by hbm2java
 */
@Entity
@Table(name = "signos", schema = "public")
public class Signos implements java.io.Serializable {

	private int idSigno;
	private Paciente paciente;
	private Date fecha;
	private String pulso;
	private String ritmo;
	private String temperatura;

	public Signos() {
	}

	public Signos(int idSigno, Paciente paciente, String pulso, String ritmo, String temperatura) {
		this.idSigno = idSigno;
		this.paciente = paciente;
		this.pulso = pulso;
		this.ritmo = ritmo;
		this.temperatura = temperatura;
	}

	public Signos(int idSigno, Paciente paciente, Date fecha, String pulso, String ritmo, String temperatura) {
		this.idSigno = idSigno;
		this.paciente = paciente;
		this.fecha = fecha;
		this.pulso = pulso;
		this.ritmo = ritmo;
		this.temperatura = temperatura;
	}

	@Id

	@Column(name = "id_signo", unique = true, nullable = false)
	public int getIdSigno() {
		return this.idSigno;
	}

	public void setIdSigno(int idSigno) {
		this.idSigno = idSigno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente", nullable = false)
	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", length = 29)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "pulso", nullable = false, length = 10)
	public String getPulso() {
		return this.pulso;
	}

	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	@Column(name = "ritmo", nullable = false, length = 10)
	public String getRitmo() {
		return this.ritmo;
	}

	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}

	@Column(name = "temperatura", nullable = false, length = 10)
	public String getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

}
