package com.kedacom.kedabootdo.dao.mybatis;

import com.kedacom.core.annotion.MyBatisRepository;
import com.kedacom.kedabootdo.model.mybatis.RentSysMaterialPricePO;
import com.kedacom.security.dao.BaseDao;

import java.util.List;

/**
 * RentSysMaterialPriceMapper
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#& mapper 层 只处理复杂sql，这里的增加删除修改，只是代码生成的。
 * 继承com.kedacom.security.dao.BaseDao
 * pjm
 * 2018-04-26 11:00:56
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
@MyBatisRepository
public interface RentSysMaterialPriceMapper extends BaseDao<RentSysMaterialPricePO, Long> {
    public List<RentSysMaterialPricePO> getTransportList();

}

















