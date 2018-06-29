package com.kedacom.kedabootdo.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kedacom.kedabootdo.model.IdEntity;

/**
 * PLM任务信息
 * @author ck
 *
 */
@Entity
@Table(name = "plm_project_info")
@SequenceGenerator(name = "projectInfoGenerator", sequenceName = "PLM_PROJECT_INFO_SEQ")
public class PlmProjectInfo implements IdEntity{

	private static final long serialVersionUID = 6666634504316831743L;
	
	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "projectInfoGenerator")
	private Integer id;
	
	/**
	 * 项目名称
	 */
	@Column(name = "project_name")
	private String projectName;
	
	/**
	 * 
	 */
	@Column(name = "project_code")
	private String projectCode;
	/**
	 * 
	 */
	@Column(name = "task_name")
	private String taskName;
	/**
	 * 
	 */
	@Column(name = "task_code")
	private String taskCode;
	/**
	 * 
	 */
	@Column(name = "task_type")
	private Integer taskType;
	/**
	 * 
	 */
	@Column(name = "create_by")
	private Long createBy;
	/**
	 * 
	 */
	@Column(name = "task_planned_start_date")
	private String taskStartDate;
	/**
	 * 
	 */
	@Column(name = "task_planned_end_date")
	private String taskEndDate;
	/**
	 * 
	 */
	@Column(name = "task_status")
	private String taskStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
