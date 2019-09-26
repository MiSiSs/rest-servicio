package co.com.kalettre.logica;

import java.util.List;

import co.com.kalettre.modelo.Paciente;

public interface IPacienteLogica {
	public void registrar(Paciente p) throws Exception;
	public void actualizar(Paciente p) throws Exception;
	public void eliminar(Paciente p) throws Exception;
	public List<Paciente> findAll();
	public Paciente findId(int id);
	
}
