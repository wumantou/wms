package com.zhao.service;

import com.zhao.vo.WmsBranchVO;

import java.util.List;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:23
 * @description:
 */
public interface IWmsBranchService {

    WmsBranchVO insert(WmsBranchVO wmsBranchVO);

    WmsBranchVO update(WmsBranchVO wmsBranchVO);

    List<WmsBranchVO> findAll();

}
