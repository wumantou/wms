package com.zhao.dao;

import com.zhao.vo.WmsBranchVO;
import com.zhao.vo.WmsProductVO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;

public interface WmsProductRepository extends JpaRepositoryImplementation<WmsProductVO, Integer> {

}
