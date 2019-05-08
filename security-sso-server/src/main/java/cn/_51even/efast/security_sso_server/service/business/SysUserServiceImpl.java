package cn._51even.efast.security_sso_server.service.business;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.core.base.service.BaseService;
import cn._51even.efast.core.util.BeanCopyUtil;
import cn._51even.efast.security_sso_server.bean.entity.SysUserEntity;
import cn._51even.efast.security_sso_server.bean.request.sysUser.InsertSysUserReq;
import cn._51even.efast.security_sso_server.bean.response.SysUser.CasUserInfo;
import cn._51even.efast.security_sso_server.service.api.SysUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl extends BaseService<SysUserEntity,Integer> implements SysUserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public CasUserInfo getUserByLoginAccount(String loginAccount) {
        CasUserInfo shiroUserInfo = new CasUserInfo();
        Example example = new Example(SysUserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("loginAccount",loginAccount);
        List<SysUserEntity> sysUserEntities = select(example);
        if (sysUserEntities!=null && sysUserEntities.size() > 0){
            SysUserEntity sysUserEntity = sysUserEntities.get(0);
            BeanCopyUtil.copyProperties(shiroUserInfo,sysUserEntity);
            return shiroUserInfo;
        }
        return null;
    }

    @Override
    public ResponseResult register(InsertSysUserReq insertSysUserReq) {
        String pwdSecret = passwordEncoder.encode(insertSysUserReq.getLoginPwd());
        SysUserEntity sysUserEntity = new SysUserEntity();
        BeanCopyUtil.copyProperties(sysUserEntity,insertSysUserReq);
        sysUserEntity.setCreateTime(new Date());
        sysUserEntity.setUpdateTime(new Date());
        sysUserEntity.setLoginPwd(pwdSecret);
        boolean result = save(sysUserEntity);
        return result ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }
}
