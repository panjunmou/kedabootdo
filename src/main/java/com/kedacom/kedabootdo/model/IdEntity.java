package com.kedacom.kedabootdo.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 通用的model处理类
 * @author: Hu Zhongyuan
 * @version: 2015/4/14
 */
@MappedSuperclass
public interface IdEntity extends Serializable {
	/**
	 * 
	 * @return
	 */
	Integer getId();

	/**
	 * 
	 * @param id
	 */
	void setId(Integer id);

}

