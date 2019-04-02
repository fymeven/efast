package cn._51even.efast.security_cas_server.bean.request.sysUser;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class InsertSysUserReq implements Serializable {
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号",name = "userCode",required = true)
    private String userCode;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名",name = "userName",required = true)
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称",name = "nickName",required = true)
    private String nickName;

    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登录账号",name = "loginAccount",required = true)
    private String loginAccount;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码",name = "loginPwd",required = true)
    private String loginPwd;

    /**
     * 部门编号
     */
    @ApiModelProperty(value = "部门编号",name = "deptCode",required = true)
    private String deptCode;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别",name = "sex",required = false)
    private Integer sex;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",name = "email",required = false)
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号",name = "phone",required = false)
    private String phone;

    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码",name = "idCard",required = true)
    private String idCard;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像",name = "headImg",required = false)
    private String headImg;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户编号
     *
     * @return user_code - 用户编号
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户编号
     *
     * @param userCode 用户编号
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取登录账号
     *
     * @return login_account - 登录账号
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * 设置登录账号
     *
     * @param loginAccount 登录账号
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    /**
     * 获取登录密码
     *
     * @return login_pwd - 登录密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 设置登录密码
     *
     * @param loginPwd 登录密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    /**
     * 获取部门编号
     *
     * @return dept_code - 部门编号
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门编号
     *
     * @param deptCode 部门编号
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取头像
     *
     * @return head_img - 头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置头像
     *
     * @param headImg 头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InsertSysUserReq other = (InsertSysUserReq) that;
        return
           (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getLoginAccount() == null ? other.getLoginAccount() == null : this.getLoginAccount().equals(other.getLoginAccount()))
            && (this.getLoginPwd() == null ? other.getLoginPwd() == null : this.getLoginPwd().equals(other.getLoginPwd()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getHeadImg() == null ? other.getHeadImg() == null : this.getHeadImg().equals(other.getHeadImg()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getLoginAccount() == null) ? 0 : getLoginAccount().hashCode());
        result = prime * result + ((getLoginPwd() == null) ? 0 : getLoginPwd().hashCode());
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getHeadImg() == null) ? 0 : getHeadImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userCode=").append(userCode);
        sb.append(", userName=").append(userName);
        sb.append(", nickName=").append(nickName);
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", loginPwd=").append(loginPwd);
        sb.append(", deptCode=").append(deptCode);
        sb.append(", sex=").append(sex);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", idCard=").append(idCard);
        sb.append(", headImg=").append(headImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}