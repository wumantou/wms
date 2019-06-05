package com.zhao.service.impl;

import com.zhao.common.enums.ProductExceptionEnum;
import com.zhao.common.exception.ServiceException;
import com.zhao.common.handle.RequestUtil;
import com.zhao.dao.WmsOperateLogRepository;
import com.zhao.dao.WmsProductRepository;
import com.zhao.service.IWmsProductService;
import com.zhao.vo.WmsOperateLogVO;
import com.zhao.vo.WmsProductVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 20:24
 * @description:
 */
@Service
public class WmsProductServiceImpl implements IWmsProductService {
    @Autowired
    private WmsProductRepository wmsProductRepository;
    @Autowired
    private WmsOperateLogRepository wmsOperateLogRepository;

    @Override
    public WmsProductVO insert(WmsProductVO wmsProductVO) {
        if (StringUtils.isBlank(wmsProductVO.getProductName())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_NAME_NULL);
        }
        if (Objects.isNull(wmsProductVO.getBranchId())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_BRANCH_NULL);
        }
        if (Objects.isNull(wmsProductVO.getStock())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_STOCK_NULL);
        }
        if (Objects.isNull(wmsProductVO.getProductCount())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_COUNT_NULL);
        }
        wmsProductVO.setIsDelete("0");
        wmsProductRepository.save(wmsProductVO);
        return wmsProductVO;
    }

    @Override
    public Page<WmsProductVO> page(WmsProductVO wmsProductVO) {

        int page = Objects.isNull(wmsProductVO.getPage()) ? 0 : wmsProductVO.getPage();
        int size = Objects.isNull(wmsProductVO.getSize()) ? 10 : wmsProductVO.getSize();

        Pageable pageable = PageRequest.of(page, size);

        return wmsProductRepository.findAll((root, query, builder) -> {
            if (StringUtils.isNotBlank(wmsProductVO.getProductName())) {
                builder.like(root.get("productName"), "%" + wmsProductVO.getProductName() + "%");
            }
            if (!Objects.isNull(wmsProductVO.getBranchId())) {
                builder.equal(root.get("branchId"), wmsProductVO.getBranchId());
            }
            builder.equal(root.get("isDelete"), "0");
            return null;
        }, pageable);
    }

    @Override
    public WmsProductVO update(WmsProductVO wmsProductVO) {

        if (Objects.isNull(wmsProductVO.getId())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_ID_NULL);
        }

        WmsProductVO newProduct = wmsProductRepository.findById(wmsProductVO.getId()).orElseThrow(() -> new ServiceException(ProductExceptionEnum.PRODUCT_ID_NULL));
        if (StringUtils.isNotBlank(wmsProductVO.getProductName())) {
            newProduct.setProductName(wmsProductVO.getProductName());
        }
        if (StringUtils.isNotBlank(wmsProductVO.getColor())) {
            newProduct.setColor(wmsProductVO.getColor());
        }
        if (StringUtils.isNotBlank(wmsProductVO.getRemark())) {
            newProduct.setRemark(wmsProductVO.getRemark());
        }
        if (!Objects.isNull(wmsProductVO.getPrice())) {
            newProduct.setPrice(wmsProductVO.getPrice());
        }

        wmsProductRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public WmsProductVO addCount(WmsProductVO wmsProductVO) {

        if (Objects.isNull(wmsProductVO.getId())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_ID_NULL);
        }
        if (Objects.isNull(wmsProductVO.getAddCount()) || wmsProductVO.getAddCount() <= 0) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_ADD_ERROR);
        }
        WmsProductVO newProduct = wmsProductRepository.findById(wmsProductVO.getId()).orElseThrow(() -> new ServiceException(ProductExceptionEnum.PRODUCT_ID_NULL));
        newProduct.setProductCount(newProduct.getProductCount() + wmsProductVO.getAddCount());
        newProduct.setStock(newProduct.getStock() + wmsProductVO.getAddCount());
        wmsProductRepository.save(newProduct);

        WmsOperateLogVO operateLogVO = WmsOperateLogVO.builder()
                .branchId(wmsProductVO.getBranchId())
                .count(wmsProductVO.getAddCount())
                .operateTime(new Date())
                .productId(wmsProductVO.getId())
                .remark(wmsProductVO.getRemark())
                .userId(RequestUtil.getUser().getId())
                .operate("addCount").build();

        wmsOperateLogRepository.save(operateLogVO);

        return newProduct;
    }

    @Override
    public WmsProductVO reduceStock(WmsProductVO wmsProductVO) {
        if (Objects.isNull(wmsProductVO.getId())) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_ID_NULL);
        }
        if (Objects.isNull(wmsProductVO.getReduceStock()) || wmsProductVO.getReduceStock() <= 0) {
            throw new ServiceException(ProductExceptionEnum.PRODUCT_REDUCE_ERROR);
        }
        WmsProductVO newProduct = wmsProductRepository.findById(wmsProductVO.getId()).orElseThrow(() -> new ServiceException(ProductExceptionEnum.PRODUCT_ID_NULL));
        newProduct.setStock(newProduct.getStock() - wmsProductVO.getReduceStock());
        wmsProductRepository.save(newProduct);

        WmsOperateLogVO operateLogVO = WmsOperateLogVO.builder()
                .branchId(wmsProductVO.getBranchId())
                .count(wmsProductVO.getReduceStock())
                .operateTime(new Date())
                .productId(wmsProductVO.getId())
                .remark(wmsProductVO.getRemark())
                .userId(RequestUtil.getUser().getId())
                .operate("reduceStock").build();

        wmsOperateLogRepository.save(operateLogVO);

        return newProduct;
    }
}
