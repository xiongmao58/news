package com.pyk.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Component
public class LoginFilter  implements HandlerInterceptor {
   /* public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }
        return  false;
    }*/
}
