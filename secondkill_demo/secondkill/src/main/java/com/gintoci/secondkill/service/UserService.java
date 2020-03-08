package com.gintoci.secondkill.service;

import com.gintoci.secondkill.error.BusinessException;
import com.gintoci.secondkill.service.model.UserModel;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020-03-03 23:37
 * @Created by gin
 */
public interface UserService {
    //通过id获取用户
    UserModel getUserById(Integer id);
    //用户注册
    void register(UserModel userModel) throws BusinessException;
    //用户登录(密码加密)
    UserModel validateLogin(String telephone,String encrptPassword) throws BusinessException;
}
