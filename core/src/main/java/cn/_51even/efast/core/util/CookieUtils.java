package cn._51even.efast.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Component
public class CookieUtils {

	private static final Logger logger= LoggerFactory.getLogger(CookieUtils.class);

    /**
     * 保存cookie
     * @param response
     * @param name
     * @param value
     */
	public static void saveCookie(HttpServletResponse response,String name,String value) {
		Cookie cookie = null;
		try {
            cookie = new Cookie(name, URLEncoder.encode(value,"UTF-8"));
//            cookie = new Cookie(name, Base64.encodeBase64String(value.getBytes("UTF-8")));
            cookie.setPath("/");
            cookie.setMaxAge(-1);
		} catch (Exception e) {
            logger.error("保存cookie时发生错误",e);
		}
		response.addCookie(cookie);
	}

    /**
     * 获取cookie
     * @param request
     * @param cookieName
     * @return
     */
	public static String getCookieByName(HttpServletRequest request,String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())){
                    String value = cookie.getValue();
                    try {
                        String cookieValue = URLDecoder.decode(value,"UTF-8");
//                        String cookieValue = new String(Base64.decodeBase64(value),"UTF-8");
                        logger.info("获取cookie:"+cookieName+"="+cookieValue);
                        return cookieValue;
                    } catch (Exception e) {
                        logger.error("获取cookie时发生错误",e);
                    }
                }
            }
        }
		return null;
	}

    /**
     * 移除cookie
     * @param request
     * @param response
     * @param cookieName
     */
    public static void clearCookie(HttpServletRequest request,HttpServletResponse response,String cookieName){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())){
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }

    public static void clearAll(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }
}
