package com.kedacom.kedabootdo.vo;

import com.kedacom.kmoa.rent.enums.MaterialPriceType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * RentSysMaterialPriceVO
 * 需求申请时,计算价格;
 * 总价=物料价格+运输价格
 * 物料价格根据不同的需求申请类型决定
 * -&#& 页面处理类
 * <p>
 * pjm
 * 2018-04-26 11:00:55
 * 科达科技股份有限公司
 *
 * @version 1.0.0
 */
public class RentSysMaterialPriceVO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
    /**
     * 类型;
     * 1.需求类型(requirement)
     * 2.运输类型(transport)
     */
    private String type;
    private String typeName;
    /**
     *
     */
    private String priceType;
    private String priceTypeName;
    /**
     * 物料编码
     */
    private String materialCode;
    private String materialName;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 设置 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 获取 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置 类型;
     * 1.需求类型(requirement)
     * 2.运输类型(transport)
     */
    public String getType() {
        return type;
    }

    /**
     * 获取 类型;
     * 1.需求类型(requirement)
     * 2.运输类型(transport)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 设置
     */
    public String getPriceType() {
        return priceType;
    }

    /**
     * 获取
     */
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    /**
     * 设置 物料编码
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * 获取 物料编码
     */
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    /**
     * 设置 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 获取 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 设置 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 获取 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 设置 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 获取 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设置 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 获取 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 设置 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 获取 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPriceTypeName() {
        return priceType == null ? priceType : MaterialPriceType.getLable(this.priceType);
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}