package in.careerscale.apps.ocms.dao.model;

// Generated Mar 9, 2013 3:56:11 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * LoginMaster generated by hbm2java
 */
@Entity
@Table(name = "login_master", catalog = "ocms", uniqueConstraints = @UniqueConstraint(columnNames = "email_id"))
@NamedQuery(name = LoginMaster.FIND_BY_USERNAME, query = "select login from LoginMaster login where login.emailId= :emailId")
public class LoginMaster implements java.io.Serializable {
	public static final String FIND_BY_USERNAME = "LoginMaster.findByUsername";
	private Integer id;
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Set<Organization> organizations = new HashSet<Organization>(0);
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);
	private Set<CaseActivity> caseActivities = new HashSet<CaseActivity>(0);
	private Set<CaseMaster> caseMastersForCreatedBy = new HashSet<CaseMaster>(0);
	private Set<CaseArtifact> caseArtifacts = new HashSet<CaseArtifact>(0);
	private Set<CaseType> caseTypes = new HashSet<CaseType>(0);
	private Set<CaseMaster> caseMastersForUpdatedBy = new HashSet<CaseMaster>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private Set<HelpCategoryType> helpCategoryTypes = new HashSet<HelpCategoryType>(
			0);
	private Set<CaseUser> caseUsers = new HashSet<CaseUser>(0);

	public LoginMaster() {
	}

	public LoginMaster(String emailId, String password, String firstName,
			String lastName) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public LoginMaster(String emailId, String password, String firstName,
			String lastName,Date dateOfBirth) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth=dateOfBirth;
	}
	
	
	public LoginMaster(String emailId, String password, String firstName,
			String lastName, Date dateOfBirth, Set<Organization> organizations,
			Set<UserProfile> userProfiles, Set<CaseActivity> caseActivities,
			Set<CaseMaster> caseMastersForCreatedBy,
			Set<CaseArtifact> caseArtifacts, Set<CaseType> caseTypes,
			Set<CaseMaster> caseMastersForUpdatedBy, Set<UserRole> userRoles,
			Set<HelpCategoryType> helpCategoryTypes, Set<CaseUser> caseUsers) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.organizations = organizations;
		this.userProfiles = userProfiles;
		this.caseActivities = caseActivities;
		this.caseMastersForCreatedBy = caseMastersForCreatedBy;
		this.caseArtifacts = caseArtifacts;
		this.caseTypes = caseTypes;
		this.caseMastersForUpdatedBy = caseMastersForUpdatedBy;
		this.userRoles = userRoles;
		this.helpCategoryTypes = helpCategoryTypes;
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

	@Column(name = "email_id", unique = true, nullable = false, length = 100)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "password", nullable = false, length = 80)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", nullable = false, length = 75)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 75)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_birth", length = 0)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_organization", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "org_id", nullable = false, updatable = false) })
	public Set<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "loginMaster")
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseActivity> getCaseActivities() {
		return this.caseActivities;
	}

	public void setCaseActivities(Set<CaseActivity> caseActivities) {
		this.caseActivities = caseActivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMasterByCreatedBy")
	public Set<CaseMaster> getCaseMastersForCreatedBy() {
		return this.caseMastersForCreatedBy;
	}

	public void setCaseMastersForCreatedBy(
			Set<CaseMaster> caseMastersForCreatedBy) {
		this.caseMastersForCreatedBy = caseMastersForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseArtifact> getCaseArtifacts() {
		return this.caseArtifacts;
	}

	public void setCaseArtifacts(Set<CaseArtifact> caseArtifacts) {
		this.caseArtifacts = caseArtifacts;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "case_type_user", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "case_type_id", nullable = false, updatable = false) })
	public Set<CaseType> getCaseTypes() {
		return this.caseTypes;
	}

	public void setCaseTypes(Set<CaseType> caseTypes) {
		this.caseTypes = caseTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMasterByUpdatedBy")
	public Set<CaseMaster> getCaseMastersForUpdatedBy() {
		return this.caseMastersForUpdatedBy;
	}

	public void setCaseMastersForUpdatedBy(
			Set<CaseMaster> caseMastersForUpdatedBy) {
		this.caseMastersForUpdatedBy = caseMastersForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "loginMaster")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "help_category_user", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "help_category_id", nullable = false, updatable = false) })
	public Set<HelpCategoryType> getHelpCategoryTypes() {
		return this.helpCategoryTypes;
	}

	public void setHelpCategoryTypes(Set<HelpCategoryType> helpCategoryTypes) {
		this.helpCategoryTypes = helpCategoryTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseUser> getCaseUsers() {
		return this.caseUsers;
	}

	public void setCaseUsers(Set<CaseUser> caseUsers) {
		this.caseUsers = caseUsers;
	}

}
