package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
	
	@PersistenceContext(unitName="contribuyente")
	private EntityManager entityManager;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Importancia> resulset = query.getResultList();
				
		return resulset;
			
	}

	@Override
	public Importancia findOne(Integer c_importancia) throws DataAccessException {

		Importancia importancia = entityManager.find(Importancia.class, c_importancia);
		return importancia;
	}

}
