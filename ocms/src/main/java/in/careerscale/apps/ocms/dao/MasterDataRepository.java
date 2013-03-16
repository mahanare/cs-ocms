package in.careerscale.apps.ocms.dao;

import java.util.List;

import in.careerscale.apps.ocms.dao.model.CaseType;
import in.careerscale.apps.ocms.dao.model.HelpCategoryType;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class MasterDataRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public CaseType getCaseType(Integer id) {
		return entityManager.find(CaseType.class, id);
	}

	public void save(CaseType caseType) {
		entityManager.persist(caseType);
	}

	public HelpCategoryType getHelpCategoryType(Integer id) {
		return entityManager.find(HelpCategoryType.class, id);

	}

	public void save(HelpCategoryType helpCategoryType) {
		entityManager.persist(helpCategoryType);
	}

	
	@SuppressWarnings("unchecked")
	public List<CaseType> getCaseTypes() {
		Query query =entityManager.createQuery("SELECT c FROM Country AS c WHERE c.caseType is NULL");
		return query.getResultList();
	}
}