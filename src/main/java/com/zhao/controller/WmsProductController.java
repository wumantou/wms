package com.zhao.controller;

import com.zhao.common.base.BaseController;
import com.zhao.common.base.Result;
import com.zhao.service.IWmsProductService;
import com.zhao.vo.WmsProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:27
 * @description:
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class WmsProductController extends BaseController {
    @Autowired
    private IWmsProductService wmsProductService;

    @PostMapping("/insert")
    public Result<WmsProductVO> insert(@RequestBody WmsProductVO wmsProductVO) {
        return ok(wmsProductService.insert(wmsProductVO));
    }

    @PostMapping("/page")
    public Result<Page<WmsProductVO>> list(@RequestBody WmsProductVO wmsProductVO) {
        return ok(wmsProductService.page(wmsProductVO));
    }

    @PostMapping("/update")
    public Result<WmsProductVO> update(@RequestBody WmsProductVO wmsProductVO) {
        return ok(wmsProductService.update(wmsProductVO));
    }

    @PostMapping("/count/add")
    public Result<WmsProductVO> addCount(@RequestBody WmsProductVO wmsProductVO) {
        return ok(wmsProductService.addCount(wmsProductVO));
    }

    @PostMapping("/stock/reduce")
    public Result<WmsProductVO> reduceStock(@RequestBody WmsProductVO wmsProductVO) {
        return ok(wmsProductService.reduceStock(wmsProductVO));
    }
}

