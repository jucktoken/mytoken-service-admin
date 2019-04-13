package com.juck.mytoken.service.admin.service;

import com.juck.mytoken.service.admin.domain.TbSysUser;

public interface AdminService {
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
