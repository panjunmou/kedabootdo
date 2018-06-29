package com.kedacom.kedabootdo.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织VO
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
public class OrgTreeVo {
	/**
	 * 组织ID
	 */
	private Long orgId;
	/**
	 * ID
	 */
	private Long demId;
	/**
	 * 名称
	 */
	private String demName;
	/**
	 * 组织名称
	 */
	private String orgName;
	/**
	 * 组织描述
	 */
	private String orgDesc;
	/**
	 * 类型
	 */
	private Long orgType;
	/**
	 * 是否叶子
	 */
	private Boolean isLeaf = false;

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	/**
	 * SN
	 */
	private Long sn = Long.valueOf(0L);

	/**
	 * 组织编码
	 */
	private String orgCode;
	
	/**
	 * 分管领导
	 */
	private Long managerID;
	
	/**
	 * ehr pk
	 */
	private String ehrPk;

	/**
	 * 子
	 */
	private List<OrgTreeVo> children = new ArrayList<OrgTreeVo>();

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Long getManagerID() {
		return managerID;
	}

	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}

	public String getEhrPk() {
		return ehrPk;
	}

	public void setEhrPk(String ehrPk) {
		this.ehrPk = ehrPk;
	}

	public Long getSn() {
		return this.sn;
	}

	public void setSn(Long sn) {
		this.sn = sn;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setDemId(Long demId) {
		this.demId = demId;
	}

	public Long getDemId() {
		return this.demId;
	}

	public String getDemName() {
		return this.demName;
	}

	public void setDemName(String demName) {
		this.demName = demName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public String getOrgDesc() {
		return this.orgDesc;
	}

	public void setOrgType(Long orgType) {
		this.orgType = orgType;
	}

	public Long getOrgType() {
		return this.orgType;
	}

	public List<OrgTreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<OrgTreeVo> children) {
		this.children = children;
	}
	
	/**
	 * 增加子节点
	 * @param child
	 */
	public void addChild(OrgTreeVo child) {
		getChildren().add(child);
	}

}

