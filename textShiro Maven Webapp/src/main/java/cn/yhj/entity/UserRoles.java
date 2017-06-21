package cn.yhj.entity;

public class UserRoles {
	private Integer id;
	
	private String userCode;
	
	private String userRoles;
	
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserRols() {
		return userRoles;
	}

	public void setUserRols(String userRols) {
		this.userRoles = userRols;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public UserRoles() {}
	
	public UserRoles(Integer id, String userCode, String userRoles, String remark) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userRoles = userRoles;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserRols [id=" + id + ", userCode=" + userCode + ", userRoles="
				+ userRoles + ", remark=" + remark + "]";
	}
}
