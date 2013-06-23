package in.careerscale.apps.rms.model;

// Generated Jun 23, 2013 2:58:51 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JobPosting generated by hbm2java
 */
@Entity
@Table(name = "job_posting", catalog = "rms")
public class JobPosting implements java.io.Serializable {

	private Integer id;
	private String title;
	private String description;
	private String keywords;
	private String exerienceLevel;
	private Integer yearsOfExperience;
	private String status;
	private String source;
	private Date startDate;
	private Date targetDate;
	private Set<JobApplications> jobApplicationses = new HashSet<JobApplications>(
			0);

	public JobPosting() {
	}

	public JobPosting(String title) {
		this.title = title;
	}

	public JobPosting(String title, String description, String keywords,
			String exerienceLevel, Integer yearsOfExperience, String status,
			String source, Date startDate, Date targetDate,
			Set<JobApplications> jobApplicationses) {
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.exerienceLevel = exerienceLevel;
		this.yearsOfExperience = yearsOfExperience;
		this.status = status;
		this.source = source;
		this.startDate = startDate;
		this.targetDate = targetDate;
		this.jobApplicationses = jobApplicationses;
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

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "keywords", length = 200)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "exerience_level", length = 45)
	public String getExerienceLevel() {
		return this.exerienceLevel;
	}

	public void setExerienceLevel(String exerienceLevel) {
		this.exerienceLevel = exerienceLevel;
	}

	@Column(name = "years_of_experience")
	public Integer getYearsOfExperience() {
		return this.yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Column(name = "status", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "source", length = 45)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "target_date", length = 10)
	public Date getTargetDate() {
		return this.targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobPosting")
	public Set<JobApplications> getJobApplicationses() {
		return this.jobApplicationses;
	}

	public void setJobApplicationses(Set<JobApplications> jobApplicationses) {
		this.jobApplicationses = jobApplicationses;
	}

}