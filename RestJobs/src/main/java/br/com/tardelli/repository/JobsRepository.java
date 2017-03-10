package br.com.tardelli.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;

import br.com.tardelli.model.JobsModel;

/**
 * @author: tardelli
 * 
 */
@Repository
public class JobsRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@javax.transaction.Transactional
	public void save(JobsModel obj) {

		manager.persist(obj);
	}

	@javax.transaction.Transactional
	public void merge(JobsModel obj) {

		manager.merge(obj);
	}

	public JobsModel findById(String name) {

		return manager.find(JobsModel.class, name);
	}

	public void delete(String name) {

		JobsModel obj = this.findById(name);

		if (obj != null) {
			manager.remove(obj);
		}

	}

	public List<JobsModel> findAll() {

		return manager.createQuery("SELECT c FROM JobsModel c ", JobsModel.class).getResultList();
	}

}
