package com.zhao.dao;

import com.zhao.vo.WmsOperateLogVO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface WmsOperateLogRepository extends JpaRepositoryImplementation<WmsOperateLogVO, Integer> {
    List<WmsOperateLogVO> findAllByProductIdOrderByOperateTimeDesc(Integer productId);
}
