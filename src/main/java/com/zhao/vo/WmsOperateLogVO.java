package com.zhao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 10:38
 * @description:
 */
@Entity
@Table(name = "wms_operate_log", schema = "simple_wms", catalog = "")
@DynamicInsert
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WmsOperateLogVO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "branch_id")
    private Integer branchId;
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "count")
    private Integer count;
    @Basic
    @Column(name = "remark")
    private String remark;
    @Basic
    @Column(name = "operate")
    private String operate;
    @Basic
    @Column(name = "operate_time")
    private Date operateTime;


    @Transient
    private Integer page;
    @Transient
    private Integer size;

}
