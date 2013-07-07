package in.careerscale.apps.ocms.dao.model;

// Generated Jul 7, 2013 10:49:55 AM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CaseMaster generated by hbm2java
 */
@Entity
@Table(name = "case_master", catalog = "ocms")
public class CaseMaster implements java.io.Serializable
{

	private Integer id;
	private LoginMaster loginMasterByCreatedBy;
	private CaseStatusMaster caseStatusMaster;
	private LoginMaster loginMasterByUpdatedBy;
	private HelpCategoryType helpCategoryType;
	private CaseType caseType;
	private Address address;
	private Date createdOn;
	private Date updatedOn;
	private String personName;
	private Date dateOfBirth;
	private String caseDescription;
	private String contactNumber1;
	private String contactNumber2;
	private String source;
	private String emailId;
	private Set<CaseDiscussion> caseDiscussions = new HashSet(0);
	private Set<CaseArtifact> caseArtifacts = new HashSet(0);
	private Set<Fund> funds = new HashSet(0);
	private Set<CaseActivity> caseActivities = new HashSet(0);
	private Set<CaseUser> caseUsers = new HashSet(0);
	private Set<Notification> notifications = new HashSet(0);

	public CaseMaster()
	{
	}

	public CaseMaster(LoginMaster loginMasterByCreatedBy, CaseStatusMaster caseStatusMaster,
			LoginMaster loginMasterByUpdatedBy, HelpCategoryType helpCategoryType, CaseType caseType, Date createdOn,
			Date updatedOn, String personName, String caseDescription, String contactNumber1, String source)
	{
		this.loginMasterByCreatedBy = loginMasterByCreatedBy;
		this.caseStatusMaster = caseStatusMaster;
		this.loginMasterByUpdatedBy = loginMasterByUpdatedBy;
		this.helpCategoryType = helpCategoryType;
		this.caseType = caseType;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.personName = personName;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contactNumber1;
		this.source = source;
	}

	public CaseMaster(LoginMaster loginMasterByCreatedBy, CaseStatusMaster caseStatusMaster,
			LoginMaster loginMasterByUpdatedBy, HelpCategoryType helpCategoryType, CaseType caseType, Date createdOn,
			Date updatedOn, String personName, Date dateOfBirth, String caseDescription, String contactNumber1,
			String contactNumber2, String source, Set<CaseArtifact> caseArtifacts, Set<Fund> Funds,
			Set<CaseActivity> caseActivities, Set<CaseUser> caseUsers)
	{
		this.loginMasterByCreatedBy = loginMasterByCreatedBy;
		this.caseStatusMaster = caseStatusMaster;
		this.loginMasterByUpdatedBy = loginMasterByUpdatedBy;
		this.helpCategoryType = helpCategoryType;
		this.caseType = caseType;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.source = source;
		this.caseArtifacts = caseArtifacts;
		this.funds = funds;
		this.caseActivities = caseActivities;
		this.caseUsers = caseUsers;
	}

	public CaseMaster(Address address, LoginMaster loginMasterByCreatedBy, CaseStatusMaster caseStatusMaster,
			LoginMaster loginMasterByUpdatedBy, HelpCategoryType helpCategoryType, CaseType caseType, Date createdOn,
			Date updatedOn, String personName, Date dateOfBirth, String caseDescription, String contactNumber1,
			String contactNumber2, String source, Set<CaseArtifact> caseArtifacts, Set<Fund> funds,
			Set<CaseActivity> caseActivities, Set<CaseUser> caseUsers)
	{
		this.address = address;
		this.loginMasterByCreatedBy = loginMasterByCreatedBy;
		this.caseStatusMaster = caseStatusMaster;
		this.loginMasterByUpdatedBy = loginMasterByUpdatedBy;
		this.helpCategoryType = helpCategoryType;
		this.caseType = caseType;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.source = source;
		this.caseArtifacts = caseArtifacts;
		this.funds = funds;
		this.caseActivities = caseActivities;
		this.caseUsers = caseUsers;
	}

	public CaseMaster(LoginMaster loginMasterByCreatedBy, CaseStatusMaster caseStatusMaster,
			LoginMaster loginMasterByUpdatedBy, HelpCategoryType helpCategoryType, CaseType caseType, Address address,
			Date createdOn, Date updatedOn, String personName, Date dateOfBirth, String caseDescription,
			String contactNumber1, String contactNumber2, String source, String emailId, Set caseDiscussions,
			Set caseArtifacts, Set funds, Set caseActivities, Set caseUsers, Set notifications)
	{
		this.loginMasterByCreatedBy = loginMasterByCreatedBy;
		this.caseStatusMaster = caseStatusMaster;
		this.loginMasterByUpdatedBy = loginMasterByUpdatedBy;
		this.helpCategoryType = helpCategoryType;
		this.caseType = caseType;
		this.address = address;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.source = source;
		this.emailId = emailId;
		this.caseDiscussions = caseDiscussions;
		this.caseArtifacts = caseArtifacts;
		this.funds = funds;
		this.caseActivities = caseActivities;
		this.caseUsers = caseUsers;
		this.notifications = notifications;
	}

	public CaseMaster(Date createdDate, Date updatedDate, String personName, String emailId, Date dateOfBirth,
			String caseDescription, String contact1, String contact2, String caseSource)
	{
		this.createdOn = createdDate;
		this.updatedOn = updatedDate;
		this.personName = personName;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contact1;
		this.contactNumber2 = contact2;
		this.source = caseSource;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by", nullable = false)
	public LoginMaster getLoginMasterByCreatedBy()
	{
		return this.loginMasterByCreatedBy;
	}

	public void setLoginMasterByCreatedBy(LoginMaster loginMasterByCreatedBy)
	{
		this.loginMasterByCreatedBy = loginMasterByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "case_status_id", nullable = false)
	public CaseStatusMaster getCaseStatusMaster()
	{
		return this.caseStatusMaster;
	}

	public void setCaseStatusMaster(CaseStatusMaster caseStatusMaster)
	{
		this.caseStatusMaster = caseStatusMaster;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "updated_by", nullable = false)
	public LoginMaster getLoginMasterByUpdatedBy()
	{
		return this.loginMasterByUpdatedBy;
	}

	public void setLoginMasterByUpdatedBy(LoginMaster loginMasterByUpdatedBy)
	{
		this.loginMasterByUpdatedBy = loginMasterByUpdatedBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "help_category_id", nullable = false)
	public HelpCategoryType getHelpCategoryType()
	{
		return this.helpCategoryType;
	}

	public void setHelpCategoryType(HelpCategoryType helpCategoryType)
	{
		this.helpCategoryType = helpCategoryType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "case_type_id", nullable = false)
	public CaseType getCaseType()
	{
		return this.caseType;
	}

	public void setCaseType(CaseType caseType)
	{
		this.caseType = caseType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	public Address getAddress()
	{
		return this.address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn()
	{
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", nullable = false, length = 19)
	public Date getUpdatedOn()
	{
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}

	@Column(name = "person_name", nullable = false, length = 100)
	public String getPersonName()
	{
		return this.personName;
	}

	public void setPersonName(String personName)
	{
		this.personName = personName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_birth", length = 19)
	public Date getDateOfBirth()
	{
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "case_description", nullable = false, length = 500)
	public String getCaseDescription()
	{
		return this.caseDescription;
	}

	public void setCaseDescription(String caseDescription)
	{
		this.caseDescription = caseDescription;
	}

	@Column(name = "contact_number1", nullable = false, length = 25)
	public String getContactNumber1()
	{
		return this.contactNumber1;
	}

	public void setContactNumber1(String contactNumber1)
	{
		this.contactNumber1 = contactNumber1;
	}

	@Column(name = "contact_number2", length = 45)
	public String getContactNumber2()
	{
		return this.contactNumber2;
	}

	public void setContactNumber2(String contactNumber2)
	{
		this.contactNumber2 = contactNumber2;
	}

	@Column(name = "source", nullable = false, length = 100)
	public String getSource()
	{
		return this.source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	@Column(name = "email_id", length = 45)
	public String getEmailId()
	{
		return this.emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseDiscussion> getCaseDiscussions()
	{
		return this.caseDiscussions;
	}

	public void setCaseDiscussions(Set<CaseDiscussion> caseDiscussions)
	{
		this.caseDiscussions = caseDiscussions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseArtifact> getCaseArtifacts()
	{
		return this.caseArtifacts;
	}

	public void setCaseArtifacts(Set<CaseArtifact> caseArtifacts)
	{
		this.caseArtifacts = caseArtifacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<Fund> getFunds()
	{
		return this.funds;
	}

	public void setFunds(Set<Fund> funds)
	{
		this.funds = funds;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseActivity> getCaseActivities()
	{
		return this.caseActivities;
	}

	public void setCaseActivities(Set<CaseActivity> caseActivities)
	{
		this.caseActivities = caseActivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseUser> getCaseUsers()
	{
		return this.caseUsers;
	}

	public void setCaseUsers(Set<CaseUser> caseUsers)
	{
		this.caseUsers = caseUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<Notification> getNotifications()
	{
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications)
	{
		this.notifications = notifications;
	}

}
