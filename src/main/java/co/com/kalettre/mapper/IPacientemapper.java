package co.com.kalettre.mapper;

import java.util.List;

import co.com.kalettre.dto.PacienteDTO;
import co.com.kalettre.modelo.Paciente;

public interface IPacientemapper {
	public PacienteDTO pacienteToPacienteDTO(Paciente paciente);
	public Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO);
	
	public List<PacienteDTO> listarPacienteToListaPacienteDTO(List<Paciente> listaPaciente);
	public List<Paciente> listarPacienteDTOToListaPaciente(List<PacienteDTO> listaPacienteDTO);
		
}
