package com.xdclass.mobile.xdclassmobileredis.controller;


import com.xdclass.mobile.xdclassmobileredis.domain.ScoreFlow;
import com.xdclass.mobile.xdclassmobileredis.domain.ScoreFlowExample;
import com.xdclass.mobile.xdclassmobileredis.mapper.ScoreFlowMapper;
import com.xdclass.mobile.xdclassmobileredis.mapper.SysUserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {


    @Resource
    private ScoreFlowMapper scoreFlowMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }



    @RequestMapping("/getFlow")
    @ResponseBody
    public ScoreFlow getFlow() {
        ScoreFlowExample example = new ScoreFlowExample();
        ScoreFlowExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(1);
        return scoreFlowMapper.selectByExample(example).get(0);
    }




}
