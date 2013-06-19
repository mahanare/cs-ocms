package in.careerscale.apps.ocms.service;

import in.careerscale.apps.ocms.dao.CaseRepository;
import in.careerscale.apps.ocms.dao.MasterDataRepository;
import in.careerscale.apps.ocms.dao.NotificationRepository;
import in.careerscale.apps.ocms.dao.model.Address;
import in.careerscale.apps.ocms.dao.model.CaseArtifact;
import in.careerscale.apps.ocms.dao.model.CaseMaster;
import in.careerscale.apps.ocms.dao.model.CaseStatusMaster;
import in.careerscale.apps.ocms.dao.model.CaseType;
import in.careerscale.apps.ocms.dao.model.City;
import in.careerscale.apps.ocms.dao.model.DocumentType;
import in.careerscale.apps.ocms.dao.model.HelpCategoryType;
import in.careerscale.apps.ocms.dao.model.LoginMaster;
import in.careerscale.apps.ocms.dao.model.Notification;
import in.careerscale.apps.ocms.dao.model.NotificationRecipient;
import in.careerscale.apps.ocms.dao.model.NotificationStatus;
import in.careerscale.apps.ocms.dao.model.NotificationTemplate;
import in.careerscale.apps.ocms.service.exception.ApplicationException;
import in.careerscale.apps.ocms.web.cases.model.Case;
import in.careerscale.apps.ocms.web.cases.model.CaseArtifacts;
import in.careerscale.apps.ocms.web.cases.model.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("caseService")
public class CaseService
{

	Log log = LogFactory.getLog(CaseService.class);

	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private MasterDataRepository masterDataRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	public void setCaseRepository(CaseRepository caseRepository)
	{
		this.caseRepository = caseRepository;
	}

	public void setMasterDataRepository(MasterDataRepository masterDataRepository)
	{
		this.masterDataRepository = masterDataRepository;
	}

	public void setNotificationRepository(NotificationRepository notificationRepository)
	{
		this.notificationRepository = notificationRepository;
	}

	public CaseMaster registerCase(Case bean) throws ApplicationException
	{

		CaseMaster caseMaster;

		try
		{

			caseMaster = new CaseMaster(bean.getCreatedDate(), bean.getUpdatedDate(), bean.getPersonName(),
					bean.getEmailId(), bean.getDateOfBirth(), bean.getCaseDescription(), bean.getContact1(),
					bean.getContact2(), bean.getCaseSource());
			// TODO set DB flag as well.
			caseMaster.setCaseStatusMaster((CaseStatusMaster) masterDataRepository.getById(CaseStatusMaster.class,
					new Integer(2)));
			// TODO replace with status enum or something like that. Here 2
			// means pending in db.
			if (bean.getCaseType() > 0)
				caseMaster.setCaseType((CaseType) masterDataRepository.getCaseType(bean.getCaseType()));
			if (bean.getHelpType() > 0)
				caseMaster.setHelpCategoryType((HelpCategoryType) masterDataRepository.getHelpCategoryType(bean
						.getHelpType()));
			caseMaster.setContactNumber1(bean.getContact1());
			caseMaster.setContactNumber2(bean.getContact2());
			caseMaster.setEmailId(bean.getEmailId());
			caseMaster.setCreatedOn(Calendar.getInstance().getTime());
			caseMaster.setUpdatedOn(Calendar.getInstance().getTime());


			LoginMaster loggedInUser = getLoggedInUser();

			caseMaster.setLoginMasterByCreatedBy(loggedInUser);
			caseMaster.setLoginMasterByUpdatedBy(loggedInUser);

			City city = (City) caseRepository.getById(City.class, bean.getCityId());

			Address address = new Address(city, bean.getAddressLine1(), bean.getAddressLine2(), bean.getZipcode());
			caseRepository.save(address);
			caseMaster.setAddress(address);

			caseRepository.registerCase(caseMaster);
			bean.setId(caseMaster.getId());

			NotificationRecipient recipient = null;
			NotificationStatus status = (NotificationStatus) notificationRepository
					.getById(NotificationStatus.class, 1);
			NotificationTemplate template = (NotificationTemplate) notificationRepository.getById(
					NotificationTemplate.class, 1);
			Notification notification = new Notification("this is recipient", Calendar.getInstance().getTime(),
					Calendar.getInstance().getTime(), loggedInUser, loggedInUser, caseMaster, recipient, status,
					template);
			notificationRepository.save(notification);

		}
		catch (PersistenceException pe)
		{
			throw new ApplicationException(pe.getMessage());
		}
		return caseMaster;

	}

	private LoginMaster getLoggedInUser()
	{
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		ExtendedUser user = (ExtendedUser) authentication.getPrincipal();

		return (LoginMaster) masterDataRepository.getById(LoginMaster.class, user.getId());
	}

	public List<in.careerscale.apps.ocms.web.cases.model.DocumentType> getDocumentTypes(Integer caseTypeId)
	{
		List<in.careerscale.apps.ocms.web.cases.model.DocumentType> docTypeList = new ArrayList<in.careerscale.apps.ocms.web.cases.model.DocumentType>();
		List<DocumentType> dbDocTypes = caseRepository.getDocumentTypes(caseTypeId);
		for (DocumentType documentType : dbDocTypes)
		{
			docTypeList.add(new in.careerscale.apps.ocms.web.cases.model.DocumentType(documentType.getId(),
					documentType.getName(), documentType.getSupportedFormat(), documentType.isMandatory(), documentType
							.getMaxSize()));
		}

		return docTypeList;

	}

	public void saveCaseAtrifacts(CaseArtifacts bean)
	{
		List<Document> documents = bean.getCaseDocuments();
		LoginMaster loginMaster = getLoggedInUser();
		for (Document document : documents)
		{
			try
			{
				CaseArtifact artifact = new CaseArtifact();
				artifact.setArtifactType("test");
				artifact.setArtifact(document.getFile().getBytes());
				artifact.setCaseMaster((CaseMaster) caseRepository.getById(CaseMaster.class, bean.getCaseId()));
				artifact.setLoginMaster(loginMaster);
				caseRepository.save(artifact);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}