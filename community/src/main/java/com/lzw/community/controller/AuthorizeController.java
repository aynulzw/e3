package com.lzw.community.controller;

import com.lzw.community.dto.AccessTokenDTO;
import com.lzw.community.dto.GitHubUser;
import com.lzw.community.mapper.UserMapper;
import com.lzw.community.model.User;
import com.lzw.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * @author lzw
 * @create 2019/10/14/20:50
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value(value = "${github.client.id}")
    private String clientId;

    @Value(value = "${github.client.secret}")
    private String clientSecret;

    @Value(value = "${github.redirect.uri}")
    private String redirectUri;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);

        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);

        if(gitHubUser != null){
            //登陆成功，保存用户信息session中
            User user = new User();
            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setName(gitHubUser.getName());

            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModify(user.getGmtCreate());

            userMapper.insert(user);

            response.addCookie(new Cookie("token",token));

            return "redirect:index";
        }else{
            //登陆失败，重定向到index
            return "redirect:index";
        }
    }
}
