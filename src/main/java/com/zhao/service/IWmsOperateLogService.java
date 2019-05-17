package com.zhao.service;

import com.zhao.vo.WmsOperateLogVO;
import org.springframework.data.domain.Page;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:23
 * @description:
 */
public interface IWmsOperateLogService {

    Page<WmsOperateLogVO> page(WmsOperateLogVO wmsOperateLogVO);
}
