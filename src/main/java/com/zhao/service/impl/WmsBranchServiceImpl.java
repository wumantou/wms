package com.zhao.service.impl;

import com.zhao.common.enums.BranchExceptionEnum;
import com.zhao.common.enums.ProductExceptionEnum;
import com.zhao.common.exception.ServiceException;
import com.zhao.dao.WmsBranchRepository;
import com.zhao.service.IWmsBranchService;
import com.zhao.vo.WmsBranchVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:23
 * @description:
 */
@Service
public class WmsBranchServiceImpl implements IWmsBranchService {
    @Autowired
    private WmsBranchRepository wmsBranchRepository;

    @Override
    public WmsBranchVO insert(WmsBranchVO wmsBranchVO) {
        if (StringUtils.isBlank(wmsBranchVO.getBranchName())) {
            throw new ServiceException(BranchExceptionEnum.BRANCH_NAME_NULL);
        }

        wmsBranchRepository.save(wmsBranchVO);
        return wmsBranchVO;
    }

    @Override
    public WmsBranchVO update(WmsBranchVO wmsBranchVO) {

        if (Objects.isNull(wmsBranchVO.getId())) {
            throw new ServiceException(BranchExceptionEnum.BRANCH_ID_NULL);
        }

        WmsBranchVO branchVO = wmsBranchRepository.findById(wmsBranchVO.getId()).orElseThrow(() -> new ServiceException(BranchExceptionEnum.BRANCH_ID_NULL));
        if (StringUtils.isNotBlank(wmsBranchVO.getBranchName())) {
            branchVO.setBranchName(wmsBranchVO.getBranchName());
        }
        if (StringUtils.isNotBlank(wmsBranchVO.getRemark())) {
            branchVO.setRemark(wmsBranchVO.getRemark());
        }

        wmsBranchRepository.save(branchVO);

        return branchVO;
    }

    @Override
    public List<WmsBranchVO> findAll() {
        List<WmsBranchVO> wmsBranchVOList = new ArrayList<>();
        wmsBranchRepository.findAll().forEach(wmsBranchVOList::add);
        return wmsBranchVOList;
    }
}
