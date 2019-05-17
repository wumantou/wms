package com.zhao.dao;

import com.zhao.vo.WmsUserVO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface WmsUserRepository extends CrudRepository<WmsUserVO, Integer>, JpaSpecificationExecutor<WmsUserVO> {

    WmsUserVO findByLoginName(String loginName);

}
