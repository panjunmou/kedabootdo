package com.kedacom.kedabootdo.model;

import com.kedacom.security.model.SysUser;
import com.kedacom.security.util.ContextUtil;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * entity 基础类
 *
 * @author pangzhiwei
 * @date 2017-5-24
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class RentAuditableBaseEntity extends RentIdEntity {

    /**
     * CREATOR_ID
     */
    @Column(name = "create_id", updatable = false)
    private Long createId;
    /**
     * CREATOR_NAME
     */
    @Column(name = "create_by", updatable = false)
    private String createBy;
    /**
     * CREATOR_TIME
     */
    @Column(name = "create_time", updatable = false)
    private Date createTime;
    /**
     * UPDATE_ID
     */
    @Column(name = "update_id")
    private Long updateId;
    /**
     * UPDATE_NAME
     */
    @Column(name = "update_by")
    private String updateBy;
    /**
     * UPDATE_TIME
     */
    @Column(name = "update_time")
    private Date updateTime;

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * prePersist
     */
    @PrePersist
    public void prePersist() {
        SysUser user = ContextUtil.getCurrentUser();
        this.createTime = new Date();
        if (user != null) {
            this.createId = user.getUserId();
            this.createBy = user.getFullname();
            if (updateId == null) {
                this.updateId = user.getUserId();
                this.updateBy = user.getFullname();
                this.updateTime = new Date();
            }
        }
    }

    /**
     * preUpdate
     */
    @PreUpdate
    public void preUpdate() {
        SysUser user = ContextUtil.getCurrentUser();
        if (user != null) {
            this.updateId = user.getUserId();
            this.updateBy = user.getFullname();
        }
        this.updateTime = new Date();
    }
}
