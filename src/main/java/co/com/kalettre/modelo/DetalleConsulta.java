package co.com.kalettre.modelo;
// Generated 19/09/2019 01:37:33 PM by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DetalleConsulta generated by hbm2java
 */
@Entity
@Table(name = "detalle_consulta", schema = "public")
public class DetalleConsulta implements java.io.Serializable {

	private int idDetalle;
	private Consulta consulta;
	private String diagnostico;
	private String tratamiento;

	public DetalleConsulta() {
	}

	public DetalleConsulta(int idDetalle, Consulta consulta, String diagnostico, String tratamiento) {
		this.idDetalle = idDetalle;
		this.consulta = consulta;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
	}

	@Id

	@Column(name = "id_detalle", unique = true, nullable = false)
	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consulta", nullable = false)
	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@Column(name = "diagnostico", nullable = false, length = 70)
	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Column(name = "tratamiento", nullable = false, length = 300)
	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

}
