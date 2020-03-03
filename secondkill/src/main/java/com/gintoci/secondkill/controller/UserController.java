package com.gintoci.secondkill.controller;

import com.gintoci.secondkill.controller.viewobject.UserVO;
import com.gintoci.secondkill.service.UserService;
import com.gintoci.secondkill.service.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020-03-03 23:33
 * @Created by gin
 */
@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam(name = "id") Integer id){
        //调用service服务通过用户ID获取用户信息返回给前端
        UserModel userModel = userService.getUserById(id);

        //将核心领域模型转化为前端UI可展示的ViewObject
        return convertFromModel(userModel);

    }

    private UserVO convertFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
