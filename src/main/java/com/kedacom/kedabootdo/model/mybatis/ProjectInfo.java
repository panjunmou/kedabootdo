package com.kedacom.kedabootdo.model.mybatis;

/**
 * 项目信息
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
public class ProjectInfo {
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目编码
	 */
	private String projectCode;
	/**
	 * 任务名称
	 */
	private String taskName;
	/**
	 * 任务编码
	 */
	private String taskCode;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
