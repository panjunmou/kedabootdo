package com.kedacom.kedabootdo.controller;

import com.kedacom.kedabootdo.vo.TreeVo;
import com.kedacom.core.cache.ICache;
import com.kedacom.core.utils.ApplicationUtil;
import com.kedacom.security.model.Resources;
import com.kedacom.security.model.SubSystem;
import com.kedacom.security.service.ResourcesService;
import com.kedacom.security.service.SubSystemService;
import com.kedacom.security.util.ContextUtil;
import com.kedacom.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主界面登录界面配置
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
@Controller
@RequestMapping({ "/platform/console" })
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Resource
    private SubSystemService subSystemService;

    @Resource
    private ResourcesService resourcesService;

    //    @Resource
    //    private CacheManager cacheManager;

    /**
     * 主界面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping({ "main.do" })
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("登录进入系统后main[UserAccount]:" + ContextUtil.getCurrentUser().getAccount());
        this.subSystemService.setCurrentSystem(Long.valueOf(2), request, response);

        return new ModelAndView("console/main").addObject("currentUser", ContextUtil.getCurrentUser());
    }
    
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "getResourceNode" })
    @ResponseBody
    public Resources getResourceNode(HttpServletRequest request, HttpServletResponse response) {
        Resources resource = null;
        try {
            String columnUrl = RequestUtil.getString(request, "columnUrl");
            resource = this.resourcesService.getByUrl(columnUrl);
        } catch (Exception e) {
            return null;
        }
        return resource;
    }
    
    /**
     * 切换系统
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping({ "saveCurrSys" })
    public void saveCurrSys(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long systemId = Long.valueOf(RequestUtil.getLong(request, "systemId"));
        this.subSystemService.setCurrentSystem(systemId, request, response);
        response.sendRedirect(request.getContextPath() + "/platform/console/main.ht");
    }
    
    /**
     * 切换当前组织
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping({ "switchCurrentOrg" })
    public void switchCurrentOrg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long orgId = Long.valueOf(RequestUtil.getLong(request, "orgId"));
        ContextUtil.setCurrentOrg(orgId);
        response.sendRedirect(request.getContextPath() + "/platform/console/main.ht");
    }

    /**
     * 显示左面菜单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping({ "getSysRolResTreeData.do" })
    @ResponseBody
    public Map<String, List<TreeVo>> getSysRolResTreeData(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        logger.debug("获取菜单getSysRolResTreeData[UserAccount]:" + ContextUtil.getCurrentUser().getAccount());
        SubSystem currentSystem = subSystemService.getById(2L);//SubSystemUtil.getCurrentSystem(request);
        List<Resources> resourcesList = this.resourcesService.getSysMenu(currentSystem, ContextUtil.getCurrentUser());
        List<TreeVo> main = new ArrayList<TreeVo>();
        // 把顶层的资源加载出来

        for (Resources resources : resourcesList) {
            TreeVo tree = new TreeVo();
            tree.setResid(resources.getResId());
            tree.setIsexpand(resources.getIsOpen() == 1 ? true : false);
            tree.setText(resources.getResName());
            tree.setLeaf(resources.getIsFolder() == 1 ? false : true);
            tree.setIcon(resources.getIconCss());
            if (resources.getParentId() == 0) {
                getTreeMenu(tree, resourcesList);
                main.add(tree);
            }
        }
        Map<String, List<TreeVo>> result = new HashMap<String, List<TreeVo>>();
        result.put("items", main);
        return result;
    }

    /**
     * 获取该菜单下的所有子菜单
     * @param top
     * @param resourceList
     * @return
     */
    private void getTreeMenu(TreeVo top, List<Resources> resourceList) {
        for (Resources resource : resourceList) {
            if (!top.getResid().equals(resource.getParentId())) {
                continue;
            }
            TreeVo node = new TreeVo();
            node.setResid(resource.getResId());
            node.setText(resource.getResName());
            node.setLeaf(resource.getIsFolder() == 1 ? false : true);
            node.setUrl(RequestUtil.getHttpServletRequest().getContextPath() + resource.getDefaultUrl());
//            node.setIcon(resource.getIsFolder() == 1 ? "" : "");
            //node.setIcon(resource.getIconCss());
            node.setIcon("");
            node.setIsexpand(resource.getIsOpen() == 1 ? true : false);
            top.addChild(node);
            if (resource.getIsFolder() == 1) {
                getTreeMenu(node, resourceList);
            }
        }
    }

    /**
     * 清除系统缓存.
     *
     * @return 是否成功的字符串.
     */
    @RequestMapping("clearCache.do")
    @ResponseBody
    public String clearCache() {
        try {
            ICache iCache = (ICache) ApplicationUtil.getBean(ICache.class);
            iCache.clearAll();
        } catch (Exception e) {
            logger.error("Clear Cache failed!", e);
            return e.getMessage();
        }
        //        cacheManager.clearAll();
        return "Successful.";
    }

}
