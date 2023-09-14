package com.zclcs.erp.api.bean.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

/**
 * 系统配置 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:13.675
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("system_config")
public class SystemConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统配置id
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 业务员
     */
    @Column("salesman")
    private String salesman;

    /**
     * 联系电话
     */
    @Column("phone")
    private String phone;

    /**
     * 公司名
     */
    @Column("title")
    private String title;


}