package com.kang.shiyan02.Controller;

import com.kang.shiyan02.domain.User;
import com.kang.shiyan02.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RestController
//@RestController注解，相当于@Controller+@ResponseBody两个注解的结合， @Responsebody后，
//        返回结果直接写入HTTP response body中，不会被解析为跳转路径，所以是打印字符串的效果，不是跳转效果。
//@Controller
@RequestMapping("/user")
@CrossOrigin
public class userController {

    @Resource
    private UserService userService;

//    @PostMapping(value ="/login")
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String   login(@RequestBody User user, HttpSession session)  {
        boolean login = userService.login(user);
        System.out.println(login);
        if (login==true) {
            System.out.println("success!");
            session.setAttribute("user",user);
            System.out.println(user+"登录了");
return "success";
        }else {
            System.out.println("error");
            return "error";
        }
    }


    @PostMapping(value ="/register")
    public String registers(@RequestBody User user) {

        System.out.println(user);
        if (userService.register(user)) {

            System.out.println(userService.register(user));
            System.out.println("success!");
            return "success";
        }else {
            System.out.println("error");
            return "error";

    }}

    @RequestMapping(value ="/login02",method = RequestMethod.POST)
    public String  login02(@RequestBody User user )  {
        if (userService.login(user)) {
            System.out.println(user);
            return "/page/s.html";
        }else {
            System.out.println("error");
            return "error";
        }
    }





    @RequestMapping(value = "/item")
    public void test(HttpServletResponse rsp) throws IOException {
        //转发二
        System.out.println("redirect:/index.jsp");
        rsp.sendRedirect("/page/hello.jsp");
//        return "http://localhost:8080/LearnJS_html/shiyan02/static/page/s.html";
    }

    @RequestMapping(value ="/item02")
    public String test02()
    {
        System.out.println("item02....");
        return "/page/hello.jsp";
    }

    /**
     * 跳转至成功页面（重定向）
     * @author pan_junbiao
     */
    @RequestMapping(value = "/toSuccessView", method = RequestMethod.GET)
    public void toSuccessView(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //使用response对象实现页面重定向
        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/page/s.html");
    }




}
