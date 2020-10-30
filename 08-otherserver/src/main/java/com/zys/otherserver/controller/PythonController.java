package com.zys.otherserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.otherserver.controller
 * @Description : TODO
 * @Create on : 2020/10/29 20:16
 **/
@RestController
public class PythonController {
    @GetMapping("/python")
    public String python(){
        return "假装是python项目";
    }
}
