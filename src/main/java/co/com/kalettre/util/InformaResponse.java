package co.com.kalettre.util;

import java.util.Date;

public class InformaResponse {
	
	private String mensaje;
	private Date timestamp;
	private String detalles;
	
	public InformaResponse(String mensaje, Date timestamp, String detalles) {
		this.mensaje = mensaje;
		this.timestamp = timestamp;
		this.detalles = detalles;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	
}
