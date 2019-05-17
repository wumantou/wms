package com.zhao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 10:38
 * @description:
 */
@Entity
@Table(name = "wms_product", schema = "simple_wms", catalog = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WmsProductVO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "product_count")
    private Integer productCount;
    @Basic
    @Column(name = "branch_id")
    private Integer branchId;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "stock")
    private Integer stock;
    @Basic
    @Column(name = "remark")
    private String remark;
    @Basic
    @Column(name = "is_delete")
    private String isDelete;


    @Transient
    private Integer page;
    @Transient
    private Integer size;
    @Transient
    private Integer addCount;
    @Transient
    private Integer reduceStock;

}
