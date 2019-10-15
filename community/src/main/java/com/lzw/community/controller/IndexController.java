package com.lzw.community.controller;

import com.lzw.community.mapper.UserMapper;
import com.lzw.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * @author lzw
 * @create 2019/10/13/21:37
 */
@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/index")
    public String hello(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String tokenValue = cookie.getValue();
                User user = userMapper.findByToken(tokenValue);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
