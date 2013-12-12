package uk.ac.ncl.cs.zequnli.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import uk.ac.ncl.cs.zequnli.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Login login = handlerMethod.getMethodAnnotation(Login.class);
        if(null == login){
            return true;
        }
        HttpSession session = request.getSession();
        Object user = session.getAttribute("login");
        if(null == user){
            request.setAttribute("message","please Login ");
            request.getRequestDispatcher("login.do").forward(request,response);
            return false;
        }
        return true;
    }
}
