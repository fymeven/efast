package cn._51even.efast.security_cas_server.bean.enums;

public class GrantTypeEnum {

    public enum grantType{
        AUTHORIZATION_CODE("authorization_code","授权码类型"),
        PASSWORD("password","密码模式"),
        CLIENT_CREDENTIALS("client_credentials","客户端模式"),
        IMPLICIT("implicit","简化模式"),
        REFRESH_TOKEN("refresh_token","刷新token")
        ;
        private String code;
        private String desc;

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        grantType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }
}
