package in.careerscale.apps.ocms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.careerscale.apps.ocms.dao.MasterDataRepository;
import in.careerscale.apps.ocms.dao.model.CaseType;
import in.careerscale.apps.ocms.dao.model.HelpCategoryType;
import in.careerscale.apps.ocms.mail.EmailSender;
import in.careerscale.apps.ocms.service.exception.ApplicationException;
import in.careerscale.apps.ocms.web.backoffice.model.BOBean;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("masterDataService")
public class MasterDataService {

	@Autowired
	private MasterDataRepository repository;

	@Autowired
	private EmailSender emailService;

	public void addCaseType(BOBean caseType) throws ApplicationException {

		try {
			repository.save(new CaseType(caseType.getName(), caseType
					.getDescription()));
		} catch (PersistenceException pe) {
			throw new ApplicationException(pe.getMessage());
		}
	}
	
	 public void addHelpCategoryType(BOBean helpCategoryType) throws ApplicationException {

	        try {
	        	repository.save(new HelpCategoryType(helpCategoryType.getName(), helpCategoryType.getDescription()));
	        } catch (PersistenceException pe) {
	            throw new ApplicationException(pe.getMessage());
	        }
	    }
	 
	 
	 public Map<Integer, String> getCaseTypes() throws ApplicationException{
		 Map<Integer, String> caseTypes = new HashMap<Integer, String>();		
		   try {
			   List<CaseType> casetypesList =repository.getCaseTypes();
			   
			   for (CaseType caseType : casetypesList) {
				   caseTypes.put(caseType.getId(), caseType.getName());
				
			}
	        } catch (PersistenceException pe) {
	            throw new ApplicationException(pe.getMessage());
	        }
		   
		   return caseTypes;
	 }



}