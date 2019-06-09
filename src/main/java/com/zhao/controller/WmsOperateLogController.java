package com.zhao.controller;

import com.zhao.common.base.BaseController;
import com.zhao.common.base.Result;
import com.zhao.service.IWmsOperateLogService;
import com.zhao.vo.WmsOperateLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/operate")
@CrossOrigin
public class WmsOperateLogController extends BaseController {
    @Autowired
    private IWmsOperateLogService wmsOperateLogService;

    @PostMapping("/page")
    public Result<Page<WmsOperateLogVO>> page(@RequestBody WmsOperateLogVO wmsOperateLogVO) {
        return ok(wmsOperateLogService.page(wmsOperateLogVO));
    }

    @PostMapping("/list")
    public Result<List<WmsOperateLogVO>> list(@RequestBody WmsOperateLogVO wmsOperateLogVO) {
        return ok(wmsOperateLogService.list(wmsOperateLogVO));
    }
}

