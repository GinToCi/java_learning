package com.gintoci.secondkill;

import com.gintoci.secondkill.dao.UserDOMapper;
import com.gintoci.secondkill.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.gintoci.secondkill.*"})
@MapperScan("com.gintoci.secondkill.dao")
@RestController
public class SecondkillApplication {

    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(2);
        if (userDO == null){
            return "用户不存在！";
        }else {
            return userDO.getName();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondkillApplication.class, args);
    }

}
