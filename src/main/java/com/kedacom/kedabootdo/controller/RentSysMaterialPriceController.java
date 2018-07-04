package com.kedacom.kedabootdo.controller;

import com.kedacom.kedabootdo.service.RentSysMaterialPriceService;
import com.kedacom.kedabootdo.vo.RentSysMaterialPriceVO;
import com.kedacom.utils.ArrayUtil;
import com.kedacom.utils.RequestUtil;
import com.kedacom.web.ResultMessage;
import com.kedacom.web.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#&的界面处理controller
 * RentSysMaterialPriceController
 * 继承com.kedacom.web.controller.BaseController
 * pjm
 * 2018-04-26 11:00:56
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
@Controller
@RequestMapping({"/rent/rentSysMaterialPrice"})
public class RentSysMaterialPriceController extends BaseController {

    @Resource
    private RentSysMaterialPriceService rentSysMaterialPriceService;

    /**
     * page 列表页面
     *
     * @return
     * @throws Exception ModelAndView
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("/page.do")
    public ModelAndView page() throws Exception {
        return getAutoView();
    }

    /**
     * listData 查询所有数据 通过界面查询
     *
     * @param pageable
     * @return
     * @throws Exception Page<RentSysMaterialPricePO>
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("/listData.do")
    @ResponseBody
    public Page<RentSysMaterialPriceVO> listData(Pageable pageable) throws Exception {
        Page<RentSysMaterialPriceVO> page = rentSysMaterialPriceService.listByPage(RequestUtil.getParameterValueMap(request, false, false), pageable);
        return page;
    }


    /**
     * 查看界面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/view.do")
    public ModelAndView view(Long id) throws Exception {
        if (id == null || id == 0) {
            return this.getAutoView();
        } else {
            return this.getAutoView().addObject("vo", this.rentSysMaterialPriceService.getById(id));
        }
    }

    /**
     * 编辑界面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/editForm.do")
    public ModelAndView editForm(Long id) throws Exception {
        if (id == null || id == 0) {
            return this.getAutoView();
        } else {
            return this.getAutoView().addObject("vo", this.rentSysMaterialPriceService.getById(id));
        }
    }

    /**
     * saveOrUpdate 保存数据
     *
     * @param rentSysMaterialPriceVO
     * @return
     * @throws Exception ResultMessage
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("/saveOrUpdate.do")
    @ResponseBody
    public ResultMessage saveOrUpdate(RentSysMaterialPriceVO rentSysMaterialPriceVO) throws Exception {
        rentSysMaterialPriceVO = this.rentSysMaterialPriceService.saveOrUpdate(rentSysMaterialPriceVO);
        return new ResultMessage(ResultMessage.Success, "保存成功", rentSysMaterialPriceVO);
    }


    /**
     * delById 根据ID删除
     *
     * @param id
     * @return
     * @throws Exception ResultMessage
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("/delById.do")
    @ResponseBody
    public ResultMessage delById(Long id) throws Exception {
        this.rentSysMaterialPriceService.delById(id);
        return new ResultMessage(ResultMessage.Success, "删除成功");
    }

    /**
     * delByIds 根据多个ID字符串删除
     *
     * @param ids
     * @return
     * @throws Exception ResultMessage
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("/delByIds.do")
    @ResponseBody
    public ResultMessage delByIds(String ids) throws Exception {
        this.rentSysMaterialPriceService.delByIds(ArrayUtil.convertArray(ids.split(",")));
        return new ResultMessage(ResultMessage.Success, "删除成功");
    }
}
