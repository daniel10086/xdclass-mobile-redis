package com.xdclass.mobile.xdclassmobileredis.service;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.xdclass.mobile.xdclassmobileredis.domain.SysUser;
import com.xdclass.mobile.xdclassmobileredis.domain.SysUserExample;
import com.xdclass.mobile.xdclassmobileredis.mapper.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BloomFilterService {

    @Resource
    private SysUserMapper sysUserMapper;

    private BloomFilter<Integer> bf;

    /***
     * PostConstruct 程序启动时候加载此方法
     */
    @PostConstruct
    public void initBloomFilter() {
        SysUserExample sysUserExample = new SysUserExample();
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isEmpty(sysUserList)){
            return;
        }
        //创建布隆过滤器(默认3%误差)
        bf = BloomFilter.create(Funnels.integerFunnel(),sysUserList.size());
        for (SysUser sysUser:sysUserList) {
            bf.put(sysUser.getId());
        }
    }

    /***
     * 判断id可能存在于布隆过滤器里面
     * @param id
     * @return
     */
    public boolean userIdExists(int id){
        return bf.mightContain(id);
    }

}
