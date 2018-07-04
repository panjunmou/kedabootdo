package com.kedacom.kedabootdo.dao;

import com.kedacom.kedabootdo.model.jpa.RentSysMaterialPrice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RentSysMaterialPriceDao
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#& dao 层
 * 使用JPA分页查询 一般继承com.kedacom.security.dao.BaseJpaDao
 * public Page<PO> findByXXX(String xxx, Pageable pageable);
 * pjm
 * 2018-04-26 11:00:55
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
@Repository
public interface RentSysMaterialPriceDao extends KMOABaseDao<RentSysMaterialPrice> {

    /**
     * 查询数据
     *
     * @param priceType
     * @param type
     * @param materialCode
     * @return
     */
    RentSysMaterialPrice findByPriceTypeAndTypeAndMaterialCode(String priceType, String type, String materialCode);

    List<RentSysMaterialPrice> findByPriceType(String priceType);
}