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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQuery;

@NamedQuery(name = LoginMaster.FIND_BY_USERNAME, query = "select login from LoginMaster login where login.emailId= :emailId")

/**
 * LoginMaster generated by hbm2java
 */
@Entity
@Table(name = "login_master", catalog = "ocms", uniqueConstraints = @UniqueConstraint(columnNames = "email_id"))
public class LoginMaster implements java.io.Serializable {
	public static final String FIND_BY_USERNAME = "LoginMaster.findByUsername";
	public static final int LOCAL_REGISTERED = 1;
	public static final int SOCIAL_REGISTERED = 2;
	private Integer id;
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Integer loginType;
	private UserProfile userProfile;
	private Set<CaseArtifact> caseArtifacts = new HashSet(0);
	private Set<CaseMaster> caseMastersForCreatedBy = new HashSet(0);
	private Set<HelpCategoryType> helpCategoryTypes = new HashSet(0);
	private Set<CaseDiscussion> caseDiscussions = new HashSet(0);
	private Set<CaseUser> caseUsers = new HashSet(0);
	private Set<Organization> organizations = new HashSet(0);
	private Set<Fund> funds = new HashSet(0);
	private Set<CaseActivity> caseActivities = new HashSet(0);
	private Set<CaseMaster> caseMastersForUpdatedBy = new HashSet(0);
	private Set<CaseType> caseTypes = new HashSet(0);
	private Set<UserNetwork> userNetworks = new HashSet(0);
	private Set<UserRole> userRoles = new HashSet(0);

	private Integer loginStatus;

	public LoginMaster() {
	}

	public LoginMaster(String firstName) {
		this.firstName = firstName;
	}
	
		public LoginMaster(String emailId, String password, String firstName,
			String lastName) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginType= LOCAL_REGISTERED;
	}

	public LoginMaster(String emailId, String password, String firstName,
			String lastName, Date dateOfBirth, int loginType) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.loginType = loginType;
	}

	public LoginMaster(String emailId, String password, String firstName,
			String lastName, Date dateOfBirth, Integer loginType,
			UserProfile userProfile, Set caseArtifacts,
			Set caseMastersForCreatedBy, Set helpCategoryTypes,
			Set caseDiscussions, Set caseUsers, Set organizations, Set funds,
			Set caseActivities, Set caseMastersForUpdatedBy, Set caseTypes,
			Set userNetworks, Set userRoles) {
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.loginType = loginType;
		this.userProfile = userProfile;
		this.caseArtifacts = caseArtifacts;
		this.caseMastersForCreatedBy = caseMastersForCreatedBy;
		this.helpCategoryTypes = helpCategoryTypes;
		this.caseDiscussions = caseDiscussions;
		this.caseUsers = caseUsers;
		this.organizations = organizations;
		this.funds = funds;
		this.caseActivities = caseActivities;
		this.caseMastersForUpdatedBy = caseMastersForUpdatedBy;
		this.caseTypes = caseTypes;
		this.userNetworks = userNetworks;
		this.userRoles = userRoles;
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

	@Column(name = "email_id", unique = true, length = 100)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "password", length = 80)
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

	@Column(name = "last_name", length = 75)
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

	@Column(name = "login_type")
	public Integer getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	@Column(name = "login_status")
	public Integer getLoginStatus()
	{
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus)
	{
		this.loginStatus = loginStatus;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseArtifact> getCaseArtifacts()
	{
		return this.caseArtifacts;
	}

	public void setCaseArtifacts(Set<CaseArtifact> caseArtifacts)
	{
		this.caseArtifacts = caseArtifacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
	public Set<CaseMaster> getCaseMastersForCreatedBy()
	{
		return this.caseMastersForCreatedBy;
	}

	public void setCaseMastersForCreatedBy(Set<CaseMaster> caseMastersForCreatedBy)
	{
		this.caseMastersForCreatedBy = caseMastersForCreatedBy;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "help_category_user", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "help_category_id", nullable = false, updatable = false) })
	public Set<HelpCategoryType> getHelpCategoryTypes()
	{
		return this.helpCategoryTypes;
	}

	public void setHelpCategoryTypes(Set<HelpCategoryType> helpCategoryTypes)
	{
		this.helpCategoryTypes = helpCategoryTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseDiscussion> getCaseDiscussions()
	{
		return this.caseDiscussions;
	}

	public void setCaseDiscussions(Set<CaseDiscussion> caseDiscussions)
	{
		this.caseDiscussions = caseDiscussions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseUser> getCaseUsers()
	{
		return this.caseUsers;
	}

	public void setCaseUsers(Set<CaseUser> caseUsers)
	{
		this.caseUsers = caseUsers;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_organization", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "org_id", nullable = false, updatable = false) })
	public Set<Organization> getOrganizations()
	{
		return this.organizations;
	}

	public void setOrganizations(Set<Organization> organizations)
	{
		this.organizations = organizations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<Fund> getFunds()
	{
		return this.funds;
	}

	public void setFunds(Set<Fund> funds)
	{
		this.funds = funds;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<CaseActivity> getCaseActivities()
	{
		return this.caseActivities;
	}

	public void setCaseActivities(Set<CaseActivity> caseActivities)
	{
		this.caseActivities = caseActivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "updatedBy")
	public Set<CaseMaster> getCaseMastersForUpdatedBy()
	{
		return this.caseMastersForUpdatedBy;
	}

	public void setCaseMastersForUpdatedBy(Set<CaseMaster> caseMastersForUpdatedBy)
	{
		this.caseMastersForUpdatedBy = caseMastersForUpdatedBy;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "case_type_user", catalog = "ocms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "case_type_id", nullable = false, updatable = false) })
	public Set<CaseType> getCaseTypes()
	{
		return this.caseTypes;
	}

	public void setCaseTypes(Set<CaseType> caseTypes)
	{
		this.caseTypes = caseTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginMaster")
	public Set<UserNetwork> getUserNetworks()
	{
		return this.userNetworks;
	}

	public void setUserNetworks(Set<UserNetwork> userNetworks)
	{
		this.userNetworks = userNetworks;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "loginMaster")
	public Set<UserRole> getUserRoles()
	{
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles)
	{
		this.userRoles = userRoles;
	}

}
