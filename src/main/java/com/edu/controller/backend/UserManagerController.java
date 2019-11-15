package com.edu.controller.backend;

import com.edu.common.RoleEnum;
import com.edu.common.ServerResponse;
import com.edu.service.IUserService;
import com.edu.untils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
@CrossOrigin
@RestController
@RequestMapping(value = "/manage/")
public class UserManagerController {
    @Autowired
    IUserService userService;
    /**
     * 登录接口
     */
    @RequestMapping(value= "login/{username}/{password}")
    public ServerResponse login(@PathVariable("username")String username,
                                @PathVariable("password")String password,
                                HttpSession session){
        ServerResponse serverResponse = userService.login(username, password, RoleEnum.ROLE_ADMIN.getRole());
        if (serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return  serverResponse;
    }







}
