package jp.co.sss.dto;

public class Department {
	
	/** 部署ID */
	private int deptId;

	/** 部署名 */
	private String deptName;

	/**
	 * 部署IDを返します
	 * @return
	 */
	public int getDeptId() {
		return deptId;
	}

	/**
	 * 部署IDを設定します
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	/**
	 * 部署名を返します
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 部署名を設定します
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
