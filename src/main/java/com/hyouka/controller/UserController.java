package com.hyouka.controller;

import com.hyouka.entity.User;
import com.hyouka.service.IUserService;
import com.hyouka.service.impl.JedisClientPool;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    JedisClientPool jedisClientPool;

    @ResponseBody
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllUser() {
        List<User> userList = iUserService.getAllUser();
//        System.out.println("---------------");
        return JSONArray.fromObject(userList).toString();
    }

    @ResponseBody
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String selectAll() {

        List<User> userList = iUserService.selectAll();
//        System.out.println("---------------");
        return JSONArray.fromObject(userList).toString();
    }

    @ResponseBody
    @RequestMapping(value = "/select", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUserById(@RequestParam String userid) {
        User user = new User();
        user.setId(userid);

        String userString = jedisClientPool.hget("user", userid);
        if (userString == null) {
            System.out.println(userid + "无缓存");

            List<User> userList = iUserService.select(user);
            if (userList.size() == 1) {
                userString = userList.get(0).toString();
                jedisClientPool.hset("user", userid, userString);
            }
        } else {
            System.out.println(userid + "有缓存");
        }


        return userString;
    }



    @ResponseBody
    @RequestMapping(value = "/update" ,method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public  String updateUserById(@RequestBody User user){

       return iUserService.updateById(user)==1?"修改成功":"修改失败";
    }

}
