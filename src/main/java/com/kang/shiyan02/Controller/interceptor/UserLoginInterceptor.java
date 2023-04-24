package com.kang.shiyan02.Controller.interceptor;


import com.kang.shiyan02.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class UserLoginInterceptor implements HandlerInterceptor {

    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了拦截器的preHandle方法");
        System.out.println(request.getContextPath());
        try {
//            System.out.println(request);
            HttpSession session = request.getSession();
//            System.out.println(session);
//            String user1 = request.getParameter("user");
//            System.out.println(user1);
            //统一拦截（查询当前session是否存在user）(这里user会在每次登录成功后，写入session)
            User user = (User) session.getAttribute("user");
            if (user != null) {
                System.out.println(user+"放行了");
//                session.setAttribute("user", null);
                return true;
            }
//            System.out.println(request.getContextPath() );
            response.sendRedirect(request.getContextPath() + "/page/login04.html");
//            response.sendRedirect("error");
//            request.setAttribute("")
//            response.sendError(request.getContextPath() + "/page/")
//            PrintWriter writer = response.getWriter();
//            writer.write();
//            response.sendRedirect(request.getContextPath() + "/page/login04.html");
//            request.getRequestDispatcher("/page/login04.html").forward(request,response);
//            response.sendError(402);
//            response.getWriter().write();
            System.out.println(user+"去哪里？？？");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    /***
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("执行了拦截器的postHandle方法");
//    }
//
//    /***
//     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("执行了拦截器的afterCompletion方法");
//    }
}