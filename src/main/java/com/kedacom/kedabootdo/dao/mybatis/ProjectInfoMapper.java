package com.kedacom.kedabootdo.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kedacom.core.annotion.MyBatisRepository;
import com.kedacom.kedabootdo.model.mybatis.ProjectInfo;

/**
 * 项目的mapper类
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
@MyBatisRepository
public interface ProjectInfoMapper {
    /**
     * 获取下一个序列
     * @return
     */
    Integer getNextSeq();

    /**
     * 获取我的代办task
     * @param map
     * @return
     */
    List<ProjectInfo> getMyPendingTasks(@Param("map")Map<String, Long> map);
}
