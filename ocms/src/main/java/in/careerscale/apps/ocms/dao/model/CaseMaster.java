package in.careerscale.apps.ocms.dao.model;

// Generated Jun 6, 2011 8:21:35 AM by Hibernate Tools 3.4.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class CaseMaster implements java.io.Serializable {

	private Integer id;
	private LoginMaster createdBy;
	@Enumerated(EnumType.ORDINAL)
	private CaseStatus caseStatus;
	private LoginMaster updatedBy;
	private CaseSubType caseSubType;
	private HelpCategory helpCategory;
	private Date createdOn;
	private Date updatedOn;
	private String personName;
	private Date dateOfBirth;
	private String caseDescription;
	private String contactNumber1;
	private String contactNumber2;
	private String source;
	private Set<CaseArtifact> caseArtifacts = new HashSet<CaseArtifact>(0);
	private Set<FundManagement> fundManagements = new HashSet<FundManagement>(0);
	private Set<CaseActivity> caseActivities = new HashSet<CaseActivity>(0);
	private Set<CaseUser> caseUsers = new HashSet<CaseUser>(0);

	public CaseMaster() {
	}

	public CaseMaster(LoginMaster loginMasterByCreatedBy,
			CaseStatus caseStatus,
			LoginMaster loginMasterByUpdatedBy, CaseSubType caseSubType,
			HelpCategory helpCategory, Date createdOn, Date updatedOn,
			String personName, String caseDescription, String contactNumber1,
			String source) {
		this.createdBy = loginMasterByCreatedBy;
		this.caseStatus = caseStatus;
		this.updatedBy = loginMasterByUpdatedBy;
		this.caseSubType = caseSubType;
		this.helpCategory = helpCategory;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.personName = personName;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contactNumber1;
		this.source = source;
	}

	public CaseMaster(LoginMaster loginMasterByCreatedBy,
			CaseStatus caseStatus,
			LoginMaster loginMasterByUpdatedBy, CaseSubType caseSubType,
			HelpCategory helpCategory, Date createdOn, Date updatedOn,
			String personName, Date dateOfBirth, String caseDescription,
			String contactNumber1, String contactNumber2, String source,
			Set<CaseArtifact> caseArtifacts,
			Set<FundManagement> fundManagements,
			Set<CaseActivity> caseActivities, Set<CaseUser> caseUsers) {
		this.createdBy = loginMasterByCreatedBy;
		this.caseStatus = caseStatus;
		this.updatedBy = loginMasterByUpdatedBy;
		this.caseSubType = caseSubType;
		this.helpCategory = helpCategory;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.caseDescription = caseDescription;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.source = source;
		this.caseArtifacts = caseArtifacts;
		this.fundManagements = fundManagements;
		this.caseActivities = caseActivities;
		this.caseUsers = caseUsers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	public LoginMaster getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(LoginMaster createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "case_status_id", nullable = false)
	public CaseStatus getCaseStatus() {
		return this.caseStatus;
	}

	public void setCaseStatus(CaseStatus caseStatus) {
		this.caseStatus = caseStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", nullable = false)
	public LoginMaster getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(LoginMaster updatedBy) {
		this.updatedBy = updatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_sub_type_id", nullable = false)
	public CaseSubType getCaseSubType() {
		return this.caseSubType;
	}

	public void setCaseSubType(CaseSubType caseSubType) {
		this.caseSubType = caseSubType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "help_category_id", nullable = false)
	public HelpCategory getHelpCategory() {
		return this.helpCategory;
	}

	public void setHelpCategory(HelpCategory helpCategory) {
		this.helpCategory = helpCategory;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", nullable = false, length = 19)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "person_name", nullable = false, length = 100)
	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_birth", length = 19)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "case_description", nullable = false, length = 500)
	public String getCaseDescription() {
		return this.caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	@Column(name = "contact_number1", nullable = false, length = 25)
	public String getContactNumber1() {
		return this.contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	@Column(name = "contact_number2", length = 45)
	public String getContactNumber2() {
		return this.contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	@Column(name = "source", nullable = false, length = 100)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseArtifact> getCaseArtifacts() {
		return this.caseArtifacts;
	}

	public void setCaseArtifacts(Set<CaseArtifact> caseArtifacts) {
		this.caseArtifacts = caseArtifacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<FundManagement> getFundManagements() {
		return this.fundManagements;
	}

	public void setFundManagements(Set<FundManagement> fundManagements) {
		this.fundManagements = fundManagements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseActivity> getCaseActivities() {
		return this.caseActivities;
	}

	public void setCaseActivities(Set<CaseActivity> caseActivities) {
		this.caseActivities = caseActivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caseMaster")
	public Set<CaseUser> getCaseUsers() {
		return this.caseUsers;
	}

	public void setCaseUsers(Set<CaseUser> caseUsers) {
		this.caseUsers = caseUsers;
	}

}