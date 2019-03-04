package com.acd.modal;

import java.util.Date;

public class Complaint {

	private Long complaintId;
	private String complaintDescription;
	private String complaintTitle;
	private Long departmentId;
	private Date complaintDate;
	private String complaintStatus;
	private Long complaintBy;
	private Long modifiedById;
	private Department department;
	private StatusTable statusTable;

	/**
	 * @return the statusTable
	 */
	public StatusTable getStatusTable() {
		return statusTable;
	}

	/**
	 * @param statusTable the statusTable to set
	 */
	public void setStatusTable(StatusTable statusTable) {
		this.statusTable = statusTable;
	}

	/**
	 * @return the complaintId
	 */
	public Long getComplaintId() {
		return complaintId;
	}

	/**
	 * @param complaintId the complaintId to set
	 */
	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	/**
	 * @return the complaintDescription
	 */
	public String getComplaintDescription() {
		return complaintDescription;
	}

	/**
	 * @param complaintDescription the complaintDescription to set
	 */
	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	/**
	 * @return the complaintTitle
	 */
	public String getComplaintTitle() {
		return complaintTitle;
	}

	/**
	 * @param complaintTitle the complaintTitle to set
	 */
	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the complaintDate
	 */
	public Date getComplaintDate() {
		return complaintDate;
	}

	/**
	 * @param complaintDate the complaintDate to set
	 */
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	/**
	 * @return the complaintStatus
	 */
	public String getComplaintStatus() {
		return complaintStatus;
	}

	/**
	 * @param complaintStatus the complaintStatus to set
	 */
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	/**
	 * @return the complaintBy
	 */
	public Long getComplaintBy() {
		return complaintBy;
	}

	/**
	 * @param complaintBy the complaintBy to set
	 */
	public void setComplaintBy(Long complaintBy) {
		this.complaintBy = complaintBy;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the modifiedById
	 */
	public Long getModifiedById() {
		return modifiedById;
	}

	/**
	 * @param modifiedById the modifiedById to set
	 */
	public void setModifiedById(Long modifiedById) {
		this.modifiedById = modifiedById;
	}

}
