package com.juck.mytoken.service.admin.controller;

import com.juck.mytoken.common.dto.BaseResult;
import com.juck.mytoken.common.domain.TbSysUser;
import com.juck.mytoken.service.admin.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param loginCode 登录账户
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public BaseResult login(String loginCode, String password){

        //检查登录账户密码是否有效
        BaseResult baseResult = checkLoginCodeAndPassword(loginCode, password);
        if(baseResult!=null){
            return baseResult;
        }
        //登录
        TbSysUser tbSysUser = adminService.login(loginCode, password);
        //登录成功
        if(tbSysUser!=null){
            return BaseResult.ok(tbSysUser);
        }
        //登录失败
        else {
            return BaseResult.notOk(new ArrayList(){{
                add(new BaseResult.Error(loginCode, "该用户不存在，请重新注册"));
            }});
        }
    }

    private BaseResult checkLoginCodeAndPassword(String loginCode,String password){
        BaseResult baseResult = null;
        if(StringUtils.isBlank(loginCode)||StringUtils.isBlank(password)){
            baseResult = new BaseResult();
            baseResult.setErrors( new ArrayList(){{
                add(new BaseResult.Error(loginCode, "登录账户不能为空"));
                add(new BaseResult.Error(password, "密码不能为空"));
            }});
        }
        return baseResult;
    }


    @RequestMapping(value = "regist",method = RequestMethod.GET)
    public void regist(){
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode("202084");
        tbSysUser.setLoginCode("202084");
        tbSysUser.setUserName("juck");
        tbSysUser.setPassword("1234");
        tbSysUser.setUserType("1");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy("000098");
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy("000098");
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("1");
        tbSysUser.setCorpName("jj");

        adminService.regist(tbSysUser);
    }

}
