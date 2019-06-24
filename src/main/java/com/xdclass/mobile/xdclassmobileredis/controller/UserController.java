package com.xdclass.mobile.xdclassmobileredis.controller;

import com.xdclass.mobile.xdclassmobileredis.RedisService;
import com.xdclass.mobile.xdclassmobileredis.domain.SysUser;
import com.xdclass.mobile.xdclassmobileredis.mapper.SysUserMapper;
import com.xdclass.mobile.xdclassmobileredis.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {


    private static final String key = "userCache_";

    @Resource
    private SysUserMapper SysUserMapper;

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;


    @RequestMapping("/getUser")
    @ResponseBody
    public SysUser getUser(int id) {
        SysUser user = SysUserMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * set值和get值的时候序列化方式必须保持一致
     * @param id
     * @return
     */
    @RequestMapping("/getUserCache")
    @ResponseBody
    public SysUser getUseCache(Integer id) {

        //step1 先从redis里面取值
        SysUser user =  (SysUser)redisService.genValue(key + id);

        //step2 如果拿不到则从DB取值
        if (user == null) {
            SysUser userDB = SysUserMapper.selectByPrimaryKey(id);
            System.out.println("fresh value from DB id:" + id);

            //step3 DB非空情况刷新redis值
            if (userDB != null) {
                redisService.set(key + id, userDB);
                return userDB;
            }
        }
        return user;
    }


    @RequestMapping("/getByCache")
    @ResponseBody
    public SysUser getByCache(int id) {
        SysUser user = userService.findById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/getexpire", method = RequestMethod.GET)
    public SysUser findByIdTtl(int id) {
        SysUser u = new SysUser();
        try{
            u = userService.findByIdTtl(id);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return u;
    }

}
