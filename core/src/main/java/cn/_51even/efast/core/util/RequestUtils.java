package cn._51even.efast.core.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2018/5/21.
 */
public class RequestUtils {
    /**
     * 获取请求参数集合
     * @param request
     * @return
     */
    public static LinkedHashMap<String,String> getRequestParams(HttpServletRequest request){
        LinkedHashMap<String,String> paramMap = new LinkedHashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            paramMap.put(paramName, paramValue);
        }
        return paramMap;
    }

    /**
     * 获取请求参数值集合
     * @param request
     * @return
     */
    public static List<String> getRequestParamValues(HttpServletRequest request){
        LinkedHashMap requestParams = getRequestParams(request);
        return (List<String>) requestParams.values();
    }

    /**
     * 将请求参数拼接成url
     * @param request
     * @return
     */
    public static String parseParamToGetUrl(HttpServletRequest request){
        StringBuilder paramUrl = new StringBuilder();
        LinkedHashMap<String, String> requestParams = RequestUtils.getRequestParams(request);
        int paramIndex=0;
        for (Map.Entry<String, String> param : requestParams.entrySet()) {
            paramUrl.append(paramIndex == 0 ? "?" : "&");
            paramUrl.append(param.getKey()).append("=").append(param.getValue());
            paramIndex++;
        }
        return paramUrl.toString();
    }

    public static List<String> getRestApiParamValues(HttpServletRequest request,String mapping){
        String context = request.getContextPath();
        String url = request.getRequestURI().replace(context, "");
//        String mappingPrefix = mapping.substring(0, mapping.indexOf("*"));
        String replace = url.replace(mapping, "");
        String[] split = replace.split("/");
        List<String> paramList = Arrays.asList(split);
        return paramList;
    }

    /**
     * 判断是否ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request){
        return request.getHeader("accept").contains("application/json") || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").contains("XMLHttpRequest"));
    }

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }
}
