package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{

	@PersistenceContext(unitName="contribuyente")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resulset = query.getResultList();
		
		return resulset;
	}

	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Contribuyente contribuyente = entityManager.find(Contribuyente.class,code);
		return contribuyente;
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		try {
			if(contribuyente.getCcontribuyenrte() == null)
			{
				entityManager.persist(contribuyente);
			}else 
			{
				entityManager.merge(contribuyente);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer codigoContribuyente) throws DataAccessException {
		Contribuyente contribuyente = entityManager.find(Contribuyente.class, codigoContribuyente);
		entityManager.remove(contribuyente);
		
	}

}
