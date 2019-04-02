package cn._51even.efast.security_cas_server.bean.enums;

public class SysResourceEnums {

    public enum status{
        ACTIVE(1,"正常"),
        LOCK(2,"锁定"),

        ;

        private int code;
        private String desc;

        status(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
