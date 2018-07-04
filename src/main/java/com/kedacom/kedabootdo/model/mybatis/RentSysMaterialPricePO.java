package com.kedacom.kedabootdo.model.mybatis;


import com.kedacom.kedabootdo.model.jpa.RentSysMaterialPrice;

/**
 * RentSysMaterialPricePO
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#& IBatis 使用
 * <p>
 * pjm
 * 2018-04-26 11:00:55
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
public class RentSysMaterialPricePO extends RentSysMaterialPrice {

    private static final long serialVersionUID = 1L;

    private String typeName;
    private String materialName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
}