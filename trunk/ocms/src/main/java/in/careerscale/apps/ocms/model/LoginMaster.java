package in.careerscale.apps.ocms.model;

// Generated Jun 6, 2011 8:21:35 AM by Hibernate Tools 3.4.0.Beta1

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
public class LoginMaster implements java.io.Serializable {

	private Integer id;
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Set<Organization> organizations = new HashSet<Organization>(
			0);
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);
	private Set<CaseMaster> caseMastersForCreatedBy = new HashSet<CaseMaster>(0);
	
	private Set<CaseMaster> caseMastersForUpdatedBy = new HashSet<CaseMaster>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private Set<HelpCategory> helpCategories = new HashSet<HelpCategory>(0);
	private Set<CaseType> caseTypes = new HashSet<CaseType>(0);
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
			String lastName, Date dateOfBirth,
			Set<Organization> organizations,
			Set<UserProfile> userProfiles,
			Set<CaseMaster> caseMastersForCreatedBy,
			Set<CaseType> caseTypes,
			Set<CaseMaster> caseMastersForUpdatedBy, Set<UserRole> userRoles,
			Set<HelpCategory> helpCategories, Set<CaseUser> caseUsers) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.organizations = organizations;
		this.userProfiles = userProfiles;
		this.caseMastersForCreatedBy = caseMastersForCreatedBy;
		this.caseTypes = caseTypes;
		this.caseMastersForUpdatedBy = caseMastersForUpdatedBy;
		this.userRoles = userRoles;
		this.helpCategories = helpCategories;
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
	@Column(name = "date_of_birth", length = 19)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
	public Set<CaseMaster> getCaseMastersForCreatedBy() {
		return this.caseMastersForCreatedBy;
	}

	public void setCaseMastersForCreatedBy(
			Set<CaseMaster> caseMastersForCreatedBy) {
		this.caseMastersForCreatedBy = caseMastersForCreatedBy;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "case_type_user", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "case_type_id", nullable = false, updatable = false) })
	public Set<CaseType> getCaseTypes() {
		return this.caseTypes;
	}

	public void setCaseTypes(Set<CaseType> caseTypes) {
		this.caseTypes = caseTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "updatedBy")
	public Set<CaseMaster> getCaseMastersForUpdatedBy() {
		return this.caseMastersForUpdatedBy;
	}

	public void setCaseMastersForUpdatedBy(
			Set<CaseMaster> caseMastersForUpdatedBy) {
		this.caseMastersForUpdatedBy = caseMastersForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "help_category_user", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "help_category_id", nullable = false, updatable = false) })
	public Set<HelpCategory> getHelpCategories() {
		return this.helpCategories;
	}

	public void setHelpCategories(Set<HelpCategory> helpCategories) {
		this.helpCategories = helpCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseUser> getCaseUsers() {
		return this.caseUsers;
	}

	public void setCaseUsers(Set<CaseUser> caseUsers) {
		this.caseUsers = caseUsers;
	}

}
