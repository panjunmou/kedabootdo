
package com.kedacom.kedabootdo.service;

import com.kedacom.kedabootdo.dao.RentSysMaterialPriceDao;
import com.kedacom.kedabootdo.dao.mybatis.RentSysMaterialPriceMapper;
import com.kedacom.kedabootdo.exception.BusinessRuntimeException;
import com.kedacom.kedabootdo.model.jpa.RentSysMaterialPrice;
import com.kedacom.kedabootdo.model.mybatis.RentSysMaterialPricePO;
import com.kedacom.kedabootdo.vo.RentSysMaterialPriceVO;
import com.kedacom.security.service.GenericCpsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * RentSysMaterialPriceService
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#& service 处理类
 * 这个基本类一般继承com.kedacom.security.service.GenericCpsService
 * 如果自己实现转换类，通过重写getXXConveter方法。
 * pjm
 * 2018-04-26 11:00:56
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
@Service
public class RentSysMaterialPriceService extends GenericCpsService<RentSysMaterialPrice, RentSysMaterialPricePO, RentSysMaterialPriceVO, Long> {


    @Resource
    private RentSysMaterialPriceDao rentSysMaterialPriceDao;

    @Resource
    private RentSysMaterialPriceMapper rentSysMaterialPriceMapper;

    /**
     * 获取jpa的dao
     */
    @Override
    protected RentSysMaterialPriceDao getEntityJpaDao() {
        return this.rentSysMaterialPriceDao;
    }


    /**
     * 获取 mubatis 的dao
     */
    @Override
    protected RentSysMaterialPriceMapper getEntityDao() {
        return this.rentSysMaterialPriceMapper;
    }


    /**
     * saveOrUpdate 保存或者更新
     *
     * @param rentSysMaterialPriceVO
     * @return RentSysMaterialPriceVO
     * @throws
     * @since 1.0.0
     */
    public RentSysMaterialPriceVO saveOrUpdate(RentSysMaterialPriceVO rentSysMaterialPriceVO) throws Exception {
        if (rentSysMaterialPriceVO.getId() == null || rentSysMaterialPriceVO.getId() == 0L) {
            //新增
            RentSysMaterialPrice rentSysMaterialPrice = rentSysMaterialPriceDao.findByPriceTypeAndTypeAndMaterialCode(rentSysMaterialPriceVO.getPriceType(), rentSysMaterialPriceVO.getType(), rentSysMaterialPriceVO.getMaterialCode());
            if (rentSysMaterialPrice != null) {
                throw new BusinessRuntimeException("此类型报价已存在,请勿重复添加");
            }
            return this.add(rentSysMaterialPriceVO);
        } else {
            return this.update(rentSysMaterialPriceVO);
        }
    }

    @Override
    public RentSysMaterialPriceVO getById(Long id) throws Exception {
        RentSysMaterialPricePO materialPricePO = rentSysMaterialPriceMapper.getById(id);
        RentSysMaterialPriceVO priceVO = new RentSysMaterialPriceVO();
        BeanUtils.copyProperties(materialPricePO, priceVO);
        return priceVO;
    }
}
