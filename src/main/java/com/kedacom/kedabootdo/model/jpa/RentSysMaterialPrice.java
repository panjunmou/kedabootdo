package com.kedacom.kedabootdo.model.jpa;


import com.kedacom.kedabootdo.model.RentAuditableBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * RentSysMaterialPrice
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#&
 * <p>
 * pjm
 * 2018-04-26 11:00:55
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "rent_sys_material_price")
public class RentSysMaterialPrice extends RentAuditableBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 类型;
     * 1.需求类型(requirement)
     * 2.运输类型(transport)
     */
    @Column(name = "price_type")
    private String priceType;
    /**
     * type
     */
    @Column(name = "type")
    private String type;
    /**
     * 物料编码
     */
    @Column(name = "material_code")
    private String materialCode;
    /**
     * 价格
     */
    @Column(name = "price")
    private BigDecimal price;


    /**
     * 获取 类型;
     * 1.需求类型(requirement)
     * 2.运输类型(transport)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 类型;
     * 1.需求类型(requirement)
     * 2.运输类型(transport)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     */
    public String getPriceType() {
        return priceType;
    }

    /**
     * 设置
     */
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    /**
     * 获取 物料编码
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * 设置 物料编码
     */
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    /**
     * 获取 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}