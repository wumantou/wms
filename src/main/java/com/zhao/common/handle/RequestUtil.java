package com.zhao.common.handle;

import com.zhao.vo.WmsUserVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestUtil {

    private final static String USER_KEY = "session_user";
    private final static String SMS_CODE_KEY = "session_sms_code";
    private final static String SMS_TIME_KEY = "session_time_code";

    public static WmsUserVO getUser() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        return (WmsUserVO) session.getAttribute(USER_KEY);
    }

    public static void setUser(WmsUserVO user) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
        request.getSession().setAttribute(USER_KEY, user);

    }

    public static String getSmsCode() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        return (String) session.getAttribute(SMS_CODE_KEY);
    }

    public static void setSmsCode(String smsCode) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.getSession().setAttribute(SMS_CODE_KEY, smsCode);

    }

    public static Long getSmsTime() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        return (Long) session.getAttribute(SMS_TIME_KEY);
    }

    public static void setSmsTime(Long smsTime) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.getSession().setAttribute(SMS_TIME_KEY, smsTime);

    }
}
