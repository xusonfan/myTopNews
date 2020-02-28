package com.dyt.mytoplist.controller;

import com.dyt.mytoplist.pojo.V2ex;
import com.dyt.mytoplist.service.IV2exService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("v2ex")
@RestController
public class V2exController {
    @Autowired
    private IV2exService v2exService;

    @RequestMapping(method = RequestMethod.GET)
    public List<V2ex> findAll(){
        return v2exService.findAll();
    }

}
