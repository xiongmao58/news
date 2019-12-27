package com.pyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 彭义凯 on 2019/11/27.
 */
@Controller
public class IndexController {


    @RequestMapping("/getBackNews")
    public String getBackNews(){
        return "back_Index";
    }

}
