package com.kedacom.kedabootdo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kedacom.kedabootdo.model.jpa.PlmProjectInfo;
/**
 * 工程项目信息，example
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
@Repository
public interface ProjectInfoDao extends PagingAndSortingRepository<PlmProjectInfo, Integer>, JpaSpecificationExecutor<PlmProjectInfo> {

    /**
     * 根据项目编码得到PlmProjectInfo
     * @param taskCode
     * @return
     */
    List<PlmProjectInfo> findByTaskCode(String taskCode);
}

