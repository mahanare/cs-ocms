package in.careerscale.apps.ocms.dao.model;

// Generated Mar 16, 2013 8:20:08 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRoleId generated by hbm2java
 */
@Embeddable
public class UserRoleId implements java.io.Serializable {

	private int userId;
	private int roleId;
	private Integer moduleId;

	public UserRoleId() {
	}

	public UserRoleId(int userId, int roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public UserRoleId(int userId, int roleId, Integer moduleId) {
		this.userId = userId;
		this.roleId = roleId;
		this.moduleId = moduleId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "role_id", nullable = false)
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "module_id")
	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getRoleId() == castOther.getRoleId())
				&& ((this.getModuleId() == castOther.getModuleId()) || (this
						.getModuleId() != null
						&& castOther.getModuleId() != null && this
						.getModuleId().equals(castOther.getModuleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getRoleId();
		result = 37 * result
				+ (getModuleId() == null ? 0 : this.getModuleId().hashCode());
		return result;
	}

}
