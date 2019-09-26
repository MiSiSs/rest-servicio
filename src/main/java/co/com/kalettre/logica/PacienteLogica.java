package co.com.kalettre.logica;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.kalettre.dao.IPacienteDAO;
import co.com.kalettre.modelo.Paciente;


@Service
@Scope("singleton")
public class PacienteLogica implements IPacienteLogica{

	@Autowired
	private IPacienteDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(PacienteLogica.class);
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void registrar(Paciente p) throws Exception {
		try {
			int id = dao.getNextConCodigo();
			log.info("ID: "+id);
			p.setIdPaciente(id);
			dao.registrar(p);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void actualizar(Paciente p) throws Exception {
		try {
			dao.actualizar(p);
		}catch (Exception e) {
			throw new Exception("A ocurrido un error en actualizar: "+e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Paciente> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Paciente findId(int id) {		
		return dao.findId(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void eliminar(Paciente p) throws Exception{
		try {
			if(p == null) {
				throw new Exception("Paciente no existe");
			}
			Paciente pac = dao.findId(p.getIdPaciente());
			dao.eliminar(pac);
		}catch (Exception e) {			
			throw new Exception("Ha ocurrido un error en eliminar"+e.getMessage());
		}
	}

}
