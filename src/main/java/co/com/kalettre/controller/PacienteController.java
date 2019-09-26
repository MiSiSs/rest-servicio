package co.com.kalettre.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import co.com.kalettre.dto.PacienteDTO;
import co.com.kalettre.exception.ModeloNotFoundException;
import co.com.kalettre.logica.IPacienteLogica;
import co.com.kalettre.mapper.IPacientemapper;
import co.com.kalettre.modelo.Paciente;
import co.com.kalettre.util.InformaResponse;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins="*")
public class PacienteController {
	
	
	@Autowired
	private IPacienteLogica service;
	
	@Autowired
	private IPacientemapper mapper;
	
	private static Logger log = LoggerFactory.getLogger(PacienteController.class); 
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PacienteDTO>> listarRest(){
		List<Paciente> pacientes = new ArrayList<>();		
		pacientes = service.findAll();
		List<PacienteDTO> pacientesDTO = mapper.listarPacienteToListaPacienteDTO(pacientes);
		return new ResponseEntity<List<PacienteDTO>>(pacientesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> listaId(@PathVariable("id") Integer id){
		Paciente paciente = new Paciente();
		
		paciente = service.findId(id);
		
		PacienteDTO pacienteDTO = mapper.pacienteToPacienteDTO(paciente);
		
		return new ResponseEntity<PacienteDTO>(pacienteDTO, HttpStatus.OK);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Paciente paciente){
		try {
			log.info("telefono: "+paciente.getTelefono());
			service.actualizar(paciente);			
		}catch (Exception e) {
			throw new ModeloNotFoundException(e.getMessage());			
		}		
		Object obj = new InformaResponse("Se ha Guardado con exito",new Date(), "actualizar");		
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente paciente){
		try {			
			service.registrar(paciente);			
		}catch (Exception e) {	
			throw new ModeloNotFoundException(e.getMessage());			
		}
		Object obj = new InformaResponse("Se ha Guardado con exito", new Date(), "registrar");
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id){
		try {	
			Paciente paciente = new Paciente();
			paciente = service.findId(id);			
			if(paciente == null) {
				throw new ModeloNotFoundException("No paciente no existe");
			}
			log.info("ID: "+paciente.getIdPaciente());
			service.eliminar(paciente);
		}catch (Exception e) {
			log.info(e.getMessage());
			throw new ModeloNotFoundException(e.getMessage());
		}
	}
}
