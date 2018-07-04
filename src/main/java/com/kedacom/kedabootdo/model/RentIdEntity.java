package com.kedacom.kedabootdo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @Description: uddi.
 * @author: Hu Zhongyuan
 * @version: 2015/4/14
 */
@MappedSuperclass
public class RentIdEntity implements Serializable {

    /** 主键 */
    @Id
    @GeneratedValue
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
