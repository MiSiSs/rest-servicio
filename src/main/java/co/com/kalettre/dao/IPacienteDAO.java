package co.com.kalettre.dao;

import java.util.List;

import co.com.kalettre.modelo.Paciente;

public interface IPacienteDAO {
	public void registrar(Paciente p);
	public void actualizar(Paciente p);
	public void eliminar(Paciente p);
	public List<Paciente> findAll();
	public Paciente findId(int id);
	public int getNextConCodigo();
}
