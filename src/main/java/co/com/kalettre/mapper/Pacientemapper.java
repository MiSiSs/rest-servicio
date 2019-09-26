package co.com.kalettre.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.kalettre.dto.PacienteDTO;
import co.com.kalettre.modelo.Paciente;

@Component
@Scope("singleton")
public class Pacientemapper implements IPacientemapper{

	@Override
	@Transactional(readOnly=true)
	public PacienteDTO pacienteToPacienteDTO(Paciente paciente) {
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.setIdPaciente(paciente.getIdPaciente());
		pacienteDTO.setNombres(paciente.getNombres());
		pacienteDTO.setApellidos(paciente.getApellidos());
		pacienteDTO.setTelefono(paciente.getTelefono());
		pacienteDTO.setDireccion(paciente.getDireccion());
		pacienteDTO.setDni(paciente.getDni());
		
		return pacienteDTO;
	}

	@Override
	public Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO) {
		
		Paciente paciente = new Paciente();
		paciente.setIdPaciente(pacienteDTO.getIdPaciente());
		paciente.setNombres(pacienteDTO.getNombres());
		paciente.setApellidos(pacienteDTO.getApellidos());
		paciente.setDireccion(pacienteDTO.getDireccion());
		paciente.setTelefono(pacienteDTO.getTelefono());
		paciente.setDni(pacienteDTO.getDni());				
		
		return paciente;
	}

	@Override
	public List<PacienteDTO> listarPacienteToListaPacienteDTO(List<Paciente> listaPaciente) {
		List<PacienteDTO> listarPacienteDTO = new ArrayList<>();
		for(Paciente paciente : listaPaciente) {
			listarPacienteDTO.add(pacienteToPacienteDTO(paciente));
		}
		return listarPacienteDTO;
	}

	@Override
	public List<Paciente> listarPacienteDTOToListaPaciente(List<PacienteDTO> listaPacienteDTO) {
		List<Paciente> listarPaciente = new ArrayList<>();
		for(PacienteDTO pacienteDTO : listaPacienteDTO) {
			listarPaciente.add(pacienteDTOToPaciente(pacienteDTO));
		}
		return listarPaciente;
	}
	
}
