package com.zys.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.search.pojo
 * @Description : TODO
 * @Create on : 2020/10/27 17:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;
}
