package jp.co.sss.dto;

import java.sql.Date;

public class Employee {

	/** 社員ID */
	private int empId = 0;

	/** パスワード */
	private String empPass = "";

	/** 社員名 */
	private String empName = "";

	/** 性別 */
	private int gender = 0;
	
	/** 住所 */
	private String address = "";
	
	/** 誕生日 */
	private Date birthday = null;
	
	/** 権限 */
	private int authority = 0;
	
	/** 部署ID */
	private int deptId = 0;

	/** 部署テーブルの中身を保持します */
	private Department department;
	
	/**
	 * 社員IDを返します
	 * @return
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * 社員IDを設定します
	 * @param empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * パスワードを返します
	 * @return
	 */
	public String getEmpPass() {
		return empPass;
	}

	/**
	 * パスワードを設定します
	 * @param empPass
	 */
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	/**
	 * 社員名を返します
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * 社員名を設定します
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * 性別を返します
	 * @return
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * 性別を設定します
	 * @param gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * 住所を返します
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 住所を設定します
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 誕生日を返します
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 誕生日を設定します
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 権限を返します
	 * @return
	 */
	public int getAuthority() {
		return authority;
	}

	/**
	 * 権限を設定します
	 * @param authority
	 */
	public void setAuthority(int authority) {
		this.authority = authority;
	}

	/**
	 * 部署IDを返します
	 * @return
	 */
	public int getDeptId() {
		return deptId;
	}

	/**
	 * 部署IDを設定します
	 * @param deptId
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	/**
	 * 部署テーブルの中身を返します
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * 部署テーブルの中身を設定します
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

}
