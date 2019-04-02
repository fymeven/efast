package cn._51even.efast.core.system;

public class SystemEnum {

    public enum ErrorCode {
        SERVICE_ERROR("S10001","服务器异常，请联系管理员"),
        UNAUTHORIZED_LOGIN_ERROR("U20001","登录未授权"),
        UNAUTHORIZED_RESOURCE_ERROR("U20002","访问的资源未授权"),
        UNAUTHORIZED_OPERATION("U20003","操作未授权"),
        REQUEST_URL_ERROR("R30001","请求路径错误"),
        REQUEST_PARAM_ERROR("R30002","请求参数错误"),
        REQUEST_HEADER_ERROR("R30003","请求头错误"),
        LOGIN_EXPIRE("L10001","未登录或登录已过期"),
        LOGIN_PKI_ERROR("L10002","PKI认证错误"),
        LOGIN_SSO_ERROR("L10003","SSO认证失败"),
        MISS_USER_INFO("M10001","未获取到用户信息"),
        MISS_TOKEN_ERROR("M10002","未获取到TOKEN"),
        PKI_INFO_ERROR("P10001","获取PKI信息错误"),
        PKI_EXPRIRE("P10002","PKI认证已过期"),
        PKI_UNAUTHORIZED("P10003","PKI未认证或已过期"),
        PKI_ANOTHER_LOGGED("P10004","PKI在彩云其他平台已认证")

        ;
        private String code;
        private String desc;

        ErrorCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

}
