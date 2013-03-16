package in.careerscale.apps.ocms.dao.model;

// Generated Mar 16, 2013 8:20:08 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CaseUserId generated by hbm2java
 */
@Embeddable
public class CaseUserId implements java.io.Serializable {

	private int caseId;
	private int userId;

	public CaseUserId() {
	}

	public CaseUserId(int caseId, int userId) {
		this.caseId = caseId;
		this.userId = userId;
	}

	@Column(name = "case_id", nullable = false)
	public int getCaseId() {
		return this.caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CaseUserId))
			return false;
		CaseUserId castOther = (CaseUserId) other;

		return (this.getCaseId() == castOther.getCaseId())
				&& (this.getUserId() == castOther.getUserId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCaseId();
		result = 37 * result + this.getUserId();
		return result;
	}

}
