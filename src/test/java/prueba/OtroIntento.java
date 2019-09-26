package prueba;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.kalettre.dao.IPacienteDAO;
import co.com.kalettre.logica.IPacienteLogica;
import co.com.kalettre.modelo.Paciente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class OtroIntento {

	private static final Logger log = LoggerFactory.getLogger(OtroIntento.class);

	@Autowired
	private IPacienteDAO dao;
	
	@Autowired
	private IPacienteLogica logic;
	
	@Test
	@Transactional(readOnly=true)
	public void test() {
		
		assertNotNull(dao);
		List<Paciente> list = dao.findAll();
		
		for(Paciente paciente : list) {
			log.info("paciente: "+paciente.getIdPaciente()+": "+paciente.getNombres());
		}
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void registrar() {
		Paciente paciente = new Paciente();
		try {			
			//paciente.setIdPaciente(40);
			paciente.setNombres("Josefina");
			paciente.setApellidos("Zolato");
			paciente.setDni("12345678");
			paciente.setTelefono("330102304");
			paciente.setDireccion("Calle 123 - 23A 1");
			
			//dao.registrar(paciente);
			logic.registrar(paciente);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void eliminar() {
		
		int id = 0;
		
		Paciente paciente = new Paciente();
		
		paciente = dao.findId(id);
		log.info(paciente.getNombres());
		
		dao.eliminar(paciente);
		
	}
	
	@Test
	@Transactional
	public void logicEliminar() throws Exception{
		int id = 44;
					
		Paciente paciente = new Paciente();
		
		paciente = logic.findId(id);
		
		logic.eliminar(paciente);
	}
}
