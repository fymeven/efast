package cn._51even.efast.security_sso_server.config;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Md5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5Hex(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String encode = DigestUtils.md5Hex(charSequence.toString().getBytes());
        boolean res = s.equals( encode );
        return res;
    }
}
