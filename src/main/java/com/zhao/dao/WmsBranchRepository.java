package com.zhao.dao;

import com.zhao.vo.WmsBranchVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;

public interface WmsBranchRepository extends JpaRepositoryImplementation<WmsBranchVO, Integer> {

}
