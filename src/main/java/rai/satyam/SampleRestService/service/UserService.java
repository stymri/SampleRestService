package rai.satyam.SampleRestService.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rai.satyam.SampleRestService.entity.User;

@Service
public class UserService {
	
	@PersistenceUnit
	private EntityManagerFactory g_objEntityManagerFactory;
	
	private EntityManager getEntityManager() {
		return this.g_objEntityManagerFactory.createEntityManager();
	}
	
	@Transactional
	public boolean addUser(User prm_objUser) {
		boolean v_Response = false;
		EntityManager v_objEntityManager = null;
		EntityTransaction transaction = null;
		try {
			v_objEntityManager = this.getEntityManager();
			transaction =  v_objEntityManager.getTransaction();
			transaction.begin();
			v_objEntityManager.persist(prm_objUser);
		    transaction.commit();
		    v_objEntityManager.flush();
		    v_objEntityManager.close();
		    v_Response = true;
		}catch (Exception v_exException) {
			// TODO: handle exception
			v_exException.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}	
		return v_Response;
	}
	
	@Transactional(readOnly = true)
	public List<User> getAllUsers(){
		EntityManager v_objEntityManager = this.getEntityManager();
		CriteriaBuilder v_objBuilder = v_objEntityManager.getCriteriaBuilder();

		CriteriaQuery<User> v_objCriteria = v_objBuilder.createQuery(User.class);
		Root<User> v_objRoot = v_objCriteria.from( User.class );
		v_objCriteria.select( v_objRoot );
		Query v_objQuery = v_objEntityManager.createQuery(v_objCriteria);
        return v_objQuery.getResultList();
	}

	@Transactional(readOnly = true)
	public User getUserByEmail(String prm_sEmail){
		EntityManager v_objEntityManager = this.getEntityManager();
		return v_objEntityManager.find(User.class, prm_sEmail);
	}
	
	@Transactional
	public boolean deleteUserbyEmailId(String prm_sEmail) {
		boolean v_Response = false;
		EntityManager v_objEntityManager = null;
		EntityTransaction transaction = null;
		User v_objUser = null;
		try {
			v_objEntityManager = this.getEntityManager();
			transaction =  v_objEntityManager.getTransaction();
			transaction.begin();
			v_objUser =  v_objEntityManager.getReference(User.class, prm_sEmail);
			v_objEntityManager.remove(v_objUser);
			transaction.commit();
			//v_objEntityManager.flush();
		    v_objEntityManager.close();
		    v_Response = true;
		}catch (Exception v_exException) {
			// TODO: handle exception
			v_exException.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}	
		return v_Response;
	}
	
	@Transactional
	public boolean updateUser(User prm_objUser) {
		boolean v_Response = false;
		EntityManager v_objEntityManager = null;
		EntityTransaction transaction = null;
		try {
			v_objEntityManager = this.getEntityManager();
			transaction =  v_objEntityManager.getTransaction();
			transaction.begin();
			v_objEntityManager.merge(prm_objUser);
		    transaction.commit();
		    //v_objEntityManager.flush();
		    v_objEntityManager.close();
		    v_Response = true;
		}catch (Exception v_exException) {
			// TODO: handle exception
			v_exException.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}	
		return v_Response;
	}
}
