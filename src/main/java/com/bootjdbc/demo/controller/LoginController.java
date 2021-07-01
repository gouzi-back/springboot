package com.bootjdbc.demo.controller;/**
 * @Auther:haha
 * @Date:2021/4/25 - 04 - 25 21:56
 * @Description:com.hyy.config
 * @Version: 1.0
 */

import com.bootjdbc.demo.pojo.User;
import com.bootjdbc.demo.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * LoginController
 * <功能详细描述>
 *
 * @author 登录controller
 * @version [版本号, 2021/4/25 21:56]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        User login =userService.login(username, password);
        LOGGER.debug("===========================登录======================");
        //开始业务
        if (login!=null){
            session.setAttribute("loginUser",login.getRealName());
            return "redirect:/main.html"; //重定项到dashboard.html页面中 具体转换看MyMvcConfig
        }else{
            //告诉用户登入失败
            model.addAttribute("msg","用户或密码错误");
            return "index";
        }

    }


    @RequestMapping("/user/loginOut")
    public String loginOUT(HttpSession session){
        session.invalidate();
        return "redircect:/index.html";
    }
}
