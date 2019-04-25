package com.juck.mytoken.service.admin.service;

import com.juck.mytoken.common.domain.TbPostsPost;
import com.juck.mytoken.common.domain.TbSysUser;
import com.juck.mytoken.common.service.BaseService;

public interface AdminService extends BaseService<TbPostsPost> {
    /**
     * 注册
     * @param tbSysUser
     */
    public void regist(TbSysUser tbSysUser);

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     */
    public TbSysUser login(String loginCode, String plantPassword );
}
