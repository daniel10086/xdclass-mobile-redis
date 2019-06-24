package com.xdclass.mobile.xdclassmobileredis.controller;


import com.google.common.hash.BloomFilter;
import com.xdclass.mobile.xdclassmobileredis.RedisService;
import com.xdclass.mobile.xdclassmobileredis.service.BloomFilterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BloomFilterController {

    @Resource
    private BloomFilterService bloomFilterService;

    @Resource
    private RedisService redisService;

    private static final String bloomFilterName = "isVipBloom";



    @RequestMapping("/bloom/idExists")
    public boolean ifExists(int id){
        return bloomFilterService.userIdExists(id);
    }


    @RequestMapping("/bloom/redisIdExists")
    public boolean redisidExists(int id){
        return redisService.bloomFilterExists(bloomFilterName,id);
    }

    @RequestMapping("/bloom/redisIdAdd")
    public boolean redisidAdd(int id){
        return redisService.bloomFilterAdd(bloomFilterName,id);
    }

}
