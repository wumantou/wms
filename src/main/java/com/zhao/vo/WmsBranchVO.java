package com.zhao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 10:38
 * @description:
 */
@Entity
@Table(name = "wms_branch", schema = "simple_wms", catalog = "")
@DynamicInsert
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WmsBranchVO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "branch_name")
    private String branchName;
    @Basic
    @Column(name = "remark")
    private String remark;

}
