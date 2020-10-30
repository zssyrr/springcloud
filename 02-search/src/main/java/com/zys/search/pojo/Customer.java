package com.zys.search.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
