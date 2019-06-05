package com.zhao.controller;

import com.zhao.common.base.BaseController;
import com.zhao.common.base.Result;
import com.zhao.service.IWmsUserService;
import com.zhao.vo.WmsUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:27
 * @description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class WmsUserController extends BaseController {
    @Autowired
    private IWmsUserService wmsUserService;

    @PostMapping("/login")
    public Result login(@RequestBody WmsUserVO wmsUserVO) {
        return ok(wmsUserService.login(wmsUserVO));
    }
}

