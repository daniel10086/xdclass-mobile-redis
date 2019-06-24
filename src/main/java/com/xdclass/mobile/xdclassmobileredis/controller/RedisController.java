package com.xdclass.mobile.xdclassmobileredis.controller;

import com.xdclass.mobile.xdclassmobileredis.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisService service;

    @RequestMapping("/redis/setAndGet")
    @ResponseBody
    public String setAndgenValue(String name,String value){
        redisTemplate.opsForValue().set(name,value);
        return (String) redisTemplate.opsForValue().get(name);
    }


    @RequestMapping("/redis/setAndGet1")
    @ResponseBody
    public String setAndgenValueV2(String name,String value){
        service.set(name,value);
        return service.genValue(name).toString();
    }
}
