package com.kedacom.kedabootdo.dao;

import com.kedacom.security.dao.BaseJpaDao;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @param <T>BaseDao<T, Long>,
 * @author chenghongtao
 */
@NoRepositoryBean
public interface KMOABaseDao<T> extends BaseJpaDao<T, Long> {

}
