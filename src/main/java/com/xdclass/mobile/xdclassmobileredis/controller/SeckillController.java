package com.xdclass.mobile.xdclassmobileredis.controller;


import com.xdclass.mobile.xdclassmobileredis.service.SeckillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SeckillController {

    @Resource
    private SeckillService seckillService;

    @RequestMapping("/redis/seckill")
    public String secKill(int uid,int skuId){
         return seckillService.seckill(uid,skuId);
    }
}
