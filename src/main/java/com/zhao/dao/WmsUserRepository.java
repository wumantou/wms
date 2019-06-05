package com.zhao.dao;

import com.zhao.vo.WmsUserVO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface WmsUserRepository extends JpaRepositoryImplementation<WmsUserVO, Integer> {

    /**
     * 查询用户
     * @param loginName
     * @return WmsUserVO
     */
    WmsUserVO findByLoginName(String loginName);

}
