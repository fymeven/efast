package cn._51even.efast.core.util;

import cn._51even.efast.core.base.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

    private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    public static String getToken(String tokenName){
        return getToken(RequestUtils.getRequest(), tokenName);
    }

    public static String getToken(HttpServletRequest request,String tokenName){
        if (StringUtils.isBlank(tokenName)){
            throw new BusinessException("未配置token名称");
        }
        String tokenValue = request.getHeader(tokenName);
        logger.debug("tokenName:{}==tokenValue:{}",tokenName,tokenValue);
        return tokenValue;
    }

}
