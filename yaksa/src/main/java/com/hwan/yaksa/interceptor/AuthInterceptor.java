package com.hwan.yaksa.interceptor;

import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Auth auth=handlerMethod.getMethodAnnotation(Auth.class);
        if(auth==null){
            return true;
        }
        Long sessionId=(Long)request.getSession().getAttribute("sessionId");
        System.out.println("get sessionid:"+sessionId);
        if(sessionId==null){
            response.sendRedirect("/");
            return false;
        }
        else{
            if(memberService.findSession(sessionId)==false){
                response.sendRedirect("/");
                return false;
            }
            else{
                return true;
            }
        }
    }
}
