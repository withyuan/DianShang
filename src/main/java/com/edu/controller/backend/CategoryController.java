package com.edu.controller.backend;

import com.edu.common.ResponseCode;
import com.edu.common.RoleEnum;
import com.edu.common.ServerResponse;
import com.edu.pojo.Category;
import com.edu.pojo.User;
import com.edu.service.impl.CategoryServiceImpl;
import com.edu.untils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 类别接口
 *
 */
@RestController
@RequestMapping("/manage/category/")
public class CategoryController {
    @Autowired
   private  CategoryServiceImpl categoryService;

    /**
     * 添加类别manage/category/add_category.do
     */
    @RequestMapping("add_category.do")
    public ServerResponse addCategory(Category category, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createServerResponseByError(ResponseCode.NO_LOGIN, "未登录");
        }
       int role= user.getRole();
        if(role== RoleEnum.ROLE_User.getRole()){
            return ServerResponse.createServerResponseByError(ResponseCode.ERROR, "权限不足");
        }
        return categoryService.addCategory(category);
    }
    /**
     * 修改类别manage/category/set_category_name.do
     * categoryId
     * categoryName
     * categoryUrl
     */
    @RequestMapping("set_category.do")
    public ServerResponse updateCategory(Category category ,HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createServerResponseByError(ResponseCode.NO_LOGIN, "未登录");
        }
        int role= user.getRole();
        if(role== RoleEnum.ROLE_User.getRole()){
            return ServerResponse.createServerResponseByError(ResponseCode.ERROR, "权限不足");
        }
        return categoryService.updateCategory(category);
    }
    /**
     * 查看平级类别/manage/category/get_category.do
     * categoryId
     */
    @RequestMapping("{categoryId}")
    public ServerResponse getCategoryById(@PathVariable("categoryId") Integer categoryId,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createServerResponseByError(ResponseCode.NO_LOGIN, "未登录");
        }
        int role= user.getRole();
        if(role== RoleEnum.ROLE_User.getRole()){
            return ServerResponse.createServerResponseByError(ResponseCode.ERROR, "权限不足");
        }

        return categoryService.getCategoryById(categoryId);
    }
    /**
     * 查看平级类别递归子节点manage/category/get_deep_category.do
     * categoryId
     */
    @RequestMapping("deep/{categoryId}")
    public ServerResponse deepCategory(@PathVariable("categoryId") Integer categoryId,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createServerResponseByError(ResponseCode.NO_LOGIN, "未登录");
        }
        int role= user.getRole();
        if(role== RoleEnum.ROLE_User.getRole()){
            return ServerResponse.createServerResponseByError(ResponseCode.ERROR, "权限不足");
        }
        return categoryService.deepCategory(categoryId);
    }
}
