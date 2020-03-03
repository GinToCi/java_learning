package com.gintoci.secondkill.service;

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
}
