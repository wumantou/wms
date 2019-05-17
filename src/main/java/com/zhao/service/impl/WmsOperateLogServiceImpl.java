package com.zhao.service.impl;

import com.zhao.dao.WmsOperateLogRepository;
import com.zhao.service.IWmsOperateLogService;
import com.zhao.vo.WmsOperateLogVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.Objects;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:24
 * @description:
 */
@Service
public class WmsOperateLogServiceImpl implements IWmsOperateLogService {
    @Autowired
    private WmsOperateLogRepository wmsOperateLogRepository;

    @Override
    public Page<WmsOperateLogVO> page(WmsOperateLogVO wmsOperateLogVO) {
        int page = Objects.isNull(wmsOperateLogVO.getPage()) ? 1 : wmsOperateLogVO.getPage();
        int size = Objects.isNull(wmsOperateLogVO.getSize()) ? 10 : wmsOperateLogVO.getSize();

        Pageable pageable = PageRequest.of(page, size, new Sort(Sort.Direction.DESC, "id"));

        return wmsOperateLogRepository.findAll((root, query, builder) -> {

            builder.equal(root.get("operate"), wmsOperateLogVO.getOperate());
            builder.equal(root.get("productId"), wmsOperateLogVO.getProductId());

            return null;
        }, pageable);
    }
}
