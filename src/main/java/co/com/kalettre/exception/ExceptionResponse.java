package co.com.kalettre.exception;

import java.util.Date;

public class ExceptionResponse {
	private String mensaje;
	private Date timestamp;
	private String detalles;
	
	public ExceptionResponse(Date timestamp, String mensaje, String detalles) {
		this.timestamp = timestamp;
		this.mensaje = mensaje;
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
