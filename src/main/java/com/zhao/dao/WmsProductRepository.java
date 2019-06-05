package com.zhao.dao;

import com.zhao.vo.WmsProductVO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface WmsProductRepository extends JpaRepositoryImplementation<WmsProductVO, Integer> {

}
