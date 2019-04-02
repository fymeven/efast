package cn._51even.efast.security_cas_client.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JWTUtil {

    private static JWTConfig jwtConfig;

    private static final Long HOUR_MILLIS = 1000L * 60L * 60L;

    private static final String claim = "loginAccount";

    @Resource
    public void setJwtConfig(JWTConfig jwtConfig) {
        JWTUtil.jwtConfig = jwtConfig;
    }

    public static boolean verify(String token, String loginAccount, String loginPwd) {
        try {
//            Algorithm algorithm = Algorithm.HMAC256(loginPwd);
//            JWTVerifier verifier = JWT.require(algorithm).withClaim(claim, loginAccount).build();
//            verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String getLoginAccount(String token) {
//        try {
//            DecodedJWT jwt = JWT.decode(token);
//            return jwt.getClaim(claim).asString();
//        } catch (JWTDecodeException e) {
            return null;
//        }
    }

    public static String sign(String loginAccount,String loginPwd) {
//        Date date = new Date(System.currentTimeMillis()+(jwtConfig.getExpire() * HOUR_MILLIS));
//        Algorithm algorithm = Algorithm.HMAC256(loginPwd);
//        return JWT.create()
//                .withClaim(claim, loginAccount)
//                .withExpiresAt(date)
//                .sign(algorithm);
        return null;
    }

    public static boolean isExpired(String token) {
//        Date now = Calendar.getInstance().getTime();
//        DecodedJWT jwt = JWT.decode(token);
//        return jwt.getExpiresAt().before(now);
        return true;
    }
}
