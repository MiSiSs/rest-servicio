package co.com.kalettre.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.kalettre.logica.PacienteLogica;
import co.com.kalettre.modelo.Paciente;



@Repository
@Scope("singleton")
public class PacienteDAO implements IPacienteDAO{
	
	@PersistenceContext
	private EntityManager entity;

	@Override
	public void registrar(Paciente p) {
		entity.persist(p);
	}

	@Override
	public void actualizar(Paciente p) {
		entity.merge(p);
	}

	@Override
	public List<Paciente> findAll() {	
		String jpql = "select pa from Paciente pa";
		return entity.createQuery(jpql).getResultList();
	}

	@Override
	public Paciente findId(int id) {
		return entity.find(Paciente.class, id);
	}

	@Override
	public void eliminar(Paciente p) {	
		entity.remove(p);
	}

	@Override
	public int getNextConCodigo() {
		Query q = entity.createNativeQuery("select nextval('paciente_id_paciente_seq')");
		
		BigInteger id = (BigInteger)q.getSingleResult();
		return id.intValue();
	}
	
	
}
