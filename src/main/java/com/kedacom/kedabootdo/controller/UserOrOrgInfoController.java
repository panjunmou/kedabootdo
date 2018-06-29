/**
 * @(#)Exp.java 2013-12-10 Copyright 2013 it.kedacom.com, Inc. All rights
 *              reserved.
 */
package com.kedacom.kedabootdo.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedacom.security.dao.SysOrgDao;
import com.kedacom.security.model.SysOrg;
import com.kedacom.security.model.SysUserOrg;
import com.kedacom.security.service.SysUserOrgService;
import com.kedacom.security.service.impl.SysOrgService;
import com.kedacom.kedabootdo.vo.OrgTreeVo;
import com.kedacom.utils.RequestUtil;

/**
 * @author Zhaozhiqiang
 * @version 20 Dec 2013
 */
@Controller
@RequestMapping({ "/userOrOrgInfo/" })
public class UserOrOrgInfoController {
	private Logger logger = LoggerFactory.getLogger(UserOrOrgInfoController.class);

	@Resource
	private SysOrgService sysOrgService;

	@Resource
	private SysOrgDao sysOrgDao;

	@Resource
	private SysUserOrgService sysUserOrgService;

	/**
	 * 获得部门树
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "getTreeData.do" })
	@ResponseBody
	public List<OrgTreeVo> getTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long demId = Long.valueOf(RequestUtil.getLong(request, "demId", 1L));
		Long orgSupId = Long.valueOf(RequestUtil.getLong(request, "org", 1L));

		String flag = RequestUtil.getString(request, "flag");
		// 根据维度ID获取该维度下的组织列表
		List<SysOrg> orgList = this.sysOrgService.getOrgBySupIdByDemId(orgSupId, demId);//(params, null);
		List<OrgTreeVo> main = packageTreeVo(flag, orgList, 3);
		return main;
	}

	/**
	 * 获取三级部门树
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "getLevel3TreeData.do" })
	@ResponseBody
	public List<OrgTreeVo> getLevel3TreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long demId = Long.valueOf(RequestUtil.getLong(request, "demId", 1L));
		Long orgSupId = Long.valueOf(RequestUtil.getLong(request, "org", 1L));

		String flag = RequestUtil.getString(request, "flag");
		// 根据维度ID获取该维度下的组织列表
		//        Map<String, Object> params = new HashMap<String, Object>();
		//        params.put("demId", demId);
		//        params.put("orgSupId", orgSupId);
		List<SysOrg> orgList = this.sysOrgService.getOrgBySupIdByDemId(orgSupId, demId);
		List<OrgTreeVo> main = packageTreeVo(flag, orgList, 4);

		return main;
	}

	/**
	 * 组织treeVO
	 * @param orgList
	 * @param length
	 * @return
	 */
	private List<OrgTreeVo> packageTreeVo(String flag, List<SysOrg> orgList, int length) {
		List<OrgTreeVo> main = new ArrayList<OrgTreeVo>();

		for (SysOrg sysOrg : orgList) {
			SysOrg so = (SysOrg) sysOrg;
			OrgTreeVo orgVO = new OrgTreeVo();
			try {
				BeanUtils.copyProperties(orgVO, sysOrg);
			} catch (IllegalAccessException e) {
				logger.error("getTreeData", e);
			} catch (InvocationTargetException e) {
				logger.error("getTreeData", e);
			}

			if (so.getIsLeaf() == null || so.getIsLeaf().intValue() == 0) {
				orgVO.setIsLeaf(true);
			}

			// 默认显示到3级部门
			if (StringUtils.isBlank(flag) && so.getPath().split("\\.").length > length) {
				orgVO.setIsLeaf(true);
			}
			main.add(orgVO);
		}
		return main;
	}

	/**
	 * 获取根据部门获取用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "getUserByOrgId.do" })
	@ResponseBody
	public List<SysUserOrg> getUserByOrgId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long orgId = Long.valueOf(RequestUtil.getLong(request, "dept", 100L));
		SysOrg sysOrg = this.sysOrgDao.getById(orgId);
		String account = request.getParameter("account");
		Map<String, Object> filter = new HashMap<String, Object>();
		if (sysOrg != null) {
			filter.put("path", sysOrg.getPath());
		}
		filter.put("isPrimary", true);
		filter.put("account", account);
		List<SysUserOrg> list = this.sysUserOrgService.getUserForSelect(filter);

		return list;
	}
}
