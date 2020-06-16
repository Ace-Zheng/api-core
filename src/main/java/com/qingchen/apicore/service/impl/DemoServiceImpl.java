package com.qingchen.apicore.service.impl;

import com.qingchen.apicore.dao.TusersMapper;
import com.qingchen.apicore.model.Tusers;
import com.qingchen.apicore.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <ClassName>DemoServiceImpl</ClassName>
 * <Description></Description>
 *
 * @author zhenglichen
 * @date 2020年06月16日 19:31
 */

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private TusersMapper tusersMapper;

    @Override
    public List<Tusers> getUser() {
        return Arrays.asList(tusersMapper.selectByPrimaryKey(2));
    }
}
