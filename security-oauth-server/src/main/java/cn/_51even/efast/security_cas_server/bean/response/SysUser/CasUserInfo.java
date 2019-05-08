package cn._51even.efast.security_sso_server.bean.response.SysUser;

import cn._51even.efast.security_sso_server.bean.entity.SysDeptEntity;
import cn._51even.efast.security_sso_server.bean.entity.SysResourceEntity;
import cn._51even.efast.security_sso_server.bean.entity.SysRoleEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CasUserInfo implements Serializable {

    private Integer id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 登录账号
     */
    private String loginAccount;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 密码盐值
     */
    private String pwdSalt;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 部门信息
     */
    private SysDeptEntity deptInfo;

    /**
     * 角色信息
     */
    private Set<SysRoleEntity> roleInfo = new HashSet<>();

    /**
     * 资源信息
     */
    private Set<SysResourceEntity> resourceInfo = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public SysDeptEntity getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(SysDeptEntity deptInfo) {
        this.deptInfo = deptInfo;
    }

    public Set<SysRoleEntity> getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(Set<SysRoleEntity> roleInfo) {
        this.roleInfo = roleInfo;
    }

    public Set<SysResourceEntity> getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(Set<SysResourceEntity> resourceInfo) {
        this.resourceInfo = resourceInfo;
    }
}
