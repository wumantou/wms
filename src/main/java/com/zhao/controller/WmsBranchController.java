package com.zhao.controller;

import com.zhao.common.base.BaseController;
import com.zhao.common.base.Result;
import com.zhao.service.IWmsBranchService;
import com.zhao.service.IWmsUserService;
import com.zhao.vo.WmsBranchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:27
 * @description:
 */
@RestController
@RequestMapping("/branch")
public class WmsBranchController extends BaseController {
    @Autowired
    private IWmsBranchService wmsBranchService;

    @PostMapping("/insert")
    public Result<WmsBranchVO> insert(@RequestBody WmsBranchVO wmsBranchVO) {
        return ok(wmsBranchService.insert(wmsBranchVO));
    }

    @GetMapping("/list")
    public Result<List<WmsBranchVO>> list() {
        return ok(wmsBranchService.findAll());
    }

    @PostMapping("/update")
    public Result<WmsBranchVO> update(@RequestBody WmsBranchVO wmsBranchVO) {
        return ok(wmsBranchService.update(wmsBranchVO));
    }
}

