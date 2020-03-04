package com.gintoci.secondkill.controller;

import com.gintoci.secondkill.controller.viewobject.UserVO;
import com.gintoci.secondkill.error.BusinessException;
import com.gintoci.secondkill.error.EmBusinessError;
import com.gintoci.secondkill.response.CommonReturnType;
import com.gintoci.secondkill.service.UserService;
import com.gintoci.secondkill.service.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020-03-03 23:33
 * @Created by gin
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户获取opt短信接口
    @RequestMapping(value = "/getotp",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telephone") String telephone){

        //按照一定的规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        //将otp验证码通过手机号关联,使用httpsession来绑定他的手机号和otp验证码
        httpServletRequest.getSession().setAttribute(telephone,otpCode);

        //将otp验证码通过短信通道发送给用户(省略,使用控制台打印模拟 )
        System.out.println("telephone" + telephone + "&otpCode" + otpCode);

        return CommonReturnType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service服务通过用户ID获取用户信息返回给前端
        UserModel userModel = userService.getUserById(id);

        //若获取用户的信息不存在
        if (userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);
        //将核心领域模型转化为前端UI可展示的ViewObject
        return CommonReturnType.create(userVO);

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
