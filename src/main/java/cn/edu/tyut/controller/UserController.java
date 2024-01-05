package cn.edu.tyut.controller;

import cn.edu.tyut.entity.User;
import cn.edu.tyut.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 羊羊
 * @ClassName UserController
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 21:21
 * @Package_Name cn.edu.tyut.controller
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest httpServletRequest) {
        try {
            User user1 = userService.login(user);
            if(user1 != null) {
                httpServletRequest.getSession().setAttribute("USER_SESSION", user1);
                return "redirect:main";
            } else {
                httpServletRequest.setAttribute("msg", "用户名或密码错误");
                return "forward:/admin/login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpServletRequest.setAttribute("msg", "系统错误");
            return "forward:/admin/login.jsp";
        }
    }
}
