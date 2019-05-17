package com.zhao.service;

import com.zhao.vo.WmsUserVO;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:17
 * @description:
 */
public interface IWmsUserService {
    WmsUserVO login(WmsUserVO wmsUserVO);
}
