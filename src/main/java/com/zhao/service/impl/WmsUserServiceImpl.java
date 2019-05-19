package com.zhao.service.impl;

import com.zhao.common.enums.UserExceptionEnum;
import com.zhao.common.exception.ServiceException;
import com.zhao.common.handle.RequestUtil;
import com.zhao.dao.WmsUserRepository;
import com.zhao.service.IWmsUserService;
import com.zhao.vo.WmsUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:18
 * @description:
 */
@Service
public class WmsUserServiceImpl implements IWmsUserService {
    @Autowired
    private WmsUserRepository wmsUserRepository;

    @Override
    public WmsUserVO login(WmsUserVO wmsUserVO) {
        if (StringUtils.isBlank(wmsUserVO.getLoginName())) {
            throw new ServiceException(UserExceptionEnum.USER_LOGIN_NAME_NULL);
        }
        WmsUserVO loginUser = wmsUserRepository.findByLoginName(wmsUserVO.getLoginName());
        RequestUtil.setUser(loginUser);
        loginUser.setPassword(null);

        return loginUser;
    }
}
