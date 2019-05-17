package com.zhao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Version 1.0
 * @VersionDesc 初始版本
 * @Author: jerrywu
 * @Date: 2019/5/13 10:38
 * @description:
 */
@Entity
@Table(name = "wms_user", schema = "simple_wms", catalog = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WmsUserVO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "login_name")
    private String loginName;
    @Basic
    @Column(name = "nick_name")
    private String nickName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "enable")
    private String enable;

}
