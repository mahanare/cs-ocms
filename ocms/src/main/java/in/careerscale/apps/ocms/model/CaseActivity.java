package in.careerscale.apps.ocms.model;

// Generated Jun 6, 2011 8:21:35 AM by Hibernate Tools 3.4.0.Beta1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CaseActivity generated by hbm2java
 */
@Entity
@Table(name = "case_activity", catalog = "ocms")
public class CaseActivity implements java.io.Serializable {

	private Integer id;
	private CaseMaster caseMaster;
	private String action;
	private LoginMaster actionBy;
	private Date actionDate;
	private String description;

	public CaseActivity() {
	}

	public CaseActivity(CaseMaster caseMaster, String action, LoginMaster actionBy,
			Date actionDate, String description) {
		this.caseMaster = caseMaster;
		this.action = action;
		this.actionBy = actionBy;
		this.actionDate = actionDate;
		this.description = description;
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
	@JoinColumn(name = "case_id", nullable = false)
	public CaseMaster getCaseMaster() {
		return this.caseMaster;
	}

	public void setCaseMaster(CaseMaster caseMaster) {
		this.caseMaster = caseMaster;
	}

	@Column(name = "action", nullable = false)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "action_by", nullable = false)	
	public LoginMaster getActionBy() {
		return this.actionBy;
	}

	public void setActionBy(LoginMaster actionBy) {
		this.actionBy = actionBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "action_date", nullable = false, length = 19)
	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
