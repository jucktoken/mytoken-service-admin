package com.juck.mytoken.service.admin.controler;

import com.juck.mytoken.service.admin.domain.TbSysUser;
import com.juck.mytoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

@RestController
public class AdminControler {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public void login(){
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
