package com.zclcs.erp.api.bean.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 对账单
 *
 * @author zclcs
 */
@Entity
@Getter
@Setter
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 送货日期
     */
    @Column(nullable = true)
    private LocalDate deliveryDate;

    /**
     * 对账单名称
     */
    @Column(nullable = true, length = 50)
    private String name;

    /**
     * 总金额
     */
    @Column(nullable = true, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    /**
     * 所属企业
     * 设置在bill表中的关联字段(外键)
     * 可选属性optional=false,表示company不能为空。删除账单，不影响企业
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Company company;

}
