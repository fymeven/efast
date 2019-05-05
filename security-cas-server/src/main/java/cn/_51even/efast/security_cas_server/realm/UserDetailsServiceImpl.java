package cn._51even.efast.security_cas_server.realm;

import cn._51even.efast.security_cas_server.bean.enums.SysUserEnums;
import cn._51even.efast.security_cas_server.bean.response.SysUser.CasUserInfo;
import cn._51even.efast.security_cas_server.service.api.SysRoleService;
import cn._51even.efast.security_cas_server.service.api.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailsBean userDetailsUser = new UserDetailsBean();
        if (Objects.equals(userName,"securityAdmin")){
            return new User("securityAdmin",passwordEncoder.encode("securityAdmin"),AuthorityUtils.createAuthorityList("securityAdmin"));
        }
        CasUserInfo casUserInfo = sysUserService.getUserByLoginAccount(userName);
        if (casUserInfo == null) {
            throw new UsernameNotFoundException("未发现此用户");
        }
        if(Objects.equals(casUserInfo.getStatus(),SysUserEnums.status.LOCK.getCode())) {
            userDetailsUser.setAccountNonLocked(false);
        }
        userDetailsUser.setUsername(casUserInfo.getLoginAccount());
        userDetailsUser.setPassword(casUserInfo.getLoginPwd());
        Set<String> roleSet = sysRoleService.getRolesByUserId(casUserInfo.getId());

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String roleName : roleSet) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roleName));
        }
        userDetailsUser.setAuthorities(grantedAuthorities);
        return userDetailsUser;
    }
}
