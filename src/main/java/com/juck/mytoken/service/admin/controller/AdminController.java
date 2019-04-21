package com.juck.mytoken.service.admin.controller;

import com.github.pagehelper.PageInfo;
import com.juck.mytoken.common.domain.base.BaseDto;
import com.juck.mytoken.common.dto.BaseResult;
import com.juck.mytoken.common.domain.TbSysUser;
import com.juck.mytoken.service.admin.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/page/{pageNum}/{pageSize}")
    public BaseResult page(
            @PathVariable(required = true)int pageNum,
            @PathVariable(required = true)int pageSize,
            @PathVariable(required = false)TbSysUser tbSysUser){

        PageInfo<TbSysUser> pageInfo = adminService.selectPage(pageNum, pageSize, tbSysUser);
        List<TbSysUser> list = pageInfo.getList();
        return BaseResult.ok(list);
    }

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
