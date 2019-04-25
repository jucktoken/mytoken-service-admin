package com.juck.mytoken.service.admin.service.impl;

import com.juck.mytoken.common.domain.TbPostsPost;
import com.juck.mytoken.common.domain.TbSysUser;
import com.juck.mytoken.common.mapper.TbPostsPostMapper;
import com.juck.mytoken.common.mapper.TbSysUserMapper;
import com.juck.mytoken.common.service.impl.BaseServiceImpl;
import com.juck.mytoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements AdminService {
    @Override
    public void regist(TbSysUser tbSysUser) {

    }

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        return null;
    }


   /* @Override
    @Transactional(readOnly = false)
    public void regist(TbSysUser tbSysUser) {
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));
        dao.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",loginCode);
        TbSysUser tbSysUser = dao.selectOneByExample(example);

        plantPassword=DigestUtils.md5DigestAsHex(plantPassword.getBytes());
        String password=tbSysUser.getPassword();
        if(plantPassword.equals(password)){
            tbSysUser.setUserName("张建");
            return  tbSysUser;
        }
        return null;
    }*/
}
