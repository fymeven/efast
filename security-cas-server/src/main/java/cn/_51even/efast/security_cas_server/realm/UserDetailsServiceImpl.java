package cn._51even.efast.security_cas_server.realm;

import cn._51even.efast.security_cas_server.bean.entity.SysRoleEntity;
import cn._51even.efast.security_cas_server.bean.enums.SysUserEnums;
import cn._51even.efast.security_cas_server.bean.response.SysUser.CasUserInfo;
import cn._51even.efast.security_cas_server.service.api.SysRoleService;
import cn._51even.efast.security_cas_server.service.api.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailsBean userDetailsUser = new UserDetailsBean();
        CasUserInfo casUserInfo = sysUserService.getUserByLoginAccount(userName);
        if (casUserInfo == null) {
            throw new UsernameNotFoundException("未发现此用户");
        }
        if(Objects.equals(casUserInfo.getStatus(),SysUserEnums.status.LOCK.getCode())) {
            userDetailsUser.setAccountNonLocked(false);
        }
        userDetailsUser.setUsername(casUserInfo.getLoginAccount());
        userDetailsUser.setPassword(casUserInfo.getLoginPwd());
        Set<SysRoleEntity> roleSet = sysRoleService.getRolesByUserId(casUserInfo.getId());

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (SysRoleEntity sysRoleEntity : roleSet) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysRoleEntity.getRoleName());
            grantedAuthorities.add(grantedAuthority);
        }
        userDetailsUser.setAuthorities(grantedAuthorities);
        userDetailsUser.setCasUserInfo(casUserInfo);
        return userDetailsUser;
    }
}
