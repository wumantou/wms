package com.zhao.dao;

import com.zhao.vo.WmsBranchVO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface WmsBranchRepository extends CrudRepository<WmsBranchVO, Integer>, JpaSpecificationExecutor<WmsBranchVO> {

}
