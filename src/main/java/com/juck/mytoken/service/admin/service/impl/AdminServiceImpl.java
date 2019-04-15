package com.juck.mytoken.service.admin.service.impl;

import com.juck.mytoken.common.domain.TbSysUser;
import com.juck.mytoken.service.admin.mapper.TbSysUserMapper;
import com.juck.mytoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;
    @Override
    @Transactional(readOnly = false)
    public void regist(TbSysUser tbSysUser) {
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",loginCode);
        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);

        plantPassword=DigestUtils.md5DigestAsHex(plantPassword.getBytes());
        String password=tbSysUser.getPassword();
        if(plantPassword.equals(password)){
            tbSysUser.setUserName("张建");
            return  tbSysUser;
        }
        return null;
    }
}
