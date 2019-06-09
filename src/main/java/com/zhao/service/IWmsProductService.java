package com.zhao.service;

import com.zhao.vo.WmsProductVO;
import org.springframework.data.domain.Page;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:23
 * @description:
 */
public interface IWmsProductService {

    WmsProductVO insert(WmsProductVO wmsProductVO);

    Page<WmsProductVO> page(WmsProductVO wmsProductVO);

    WmsProductVO update(WmsProductVO wmsProductVO);

    WmsProductVO delete(WmsProductVO wmsProductVO);

    WmsProductVO addCount(WmsProductVO wmsProductVO);

    WmsProductVO reduceStock(WmsProductVO wmsProductVO);
}
