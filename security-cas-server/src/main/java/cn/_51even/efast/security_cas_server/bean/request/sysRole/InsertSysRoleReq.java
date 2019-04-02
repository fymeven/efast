package cn._51even.efast.security_cas_server.bean.request.sysRole;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sys_role")
public class InsertSysRoleReq implements Serializable {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称",name = "roleName",required = true)
    private String roleName;

    /**
     * 角色组
     */
    @ApiModelProperty(value = "角色组",name = "roleGroup",required = false)
    private String roleGroup;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",name = "remark",required = false)
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色组
     *
     * @return role_group - 角色组
     */
    public String getRoleGroup() {
        return roleGroup;
    }

    /**
     * 设置角色组
     *
     * @param roleGroup 角色组
     */
    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
        InsertSysRoleReq other = (InsertSysRoleReq) that;
        return
            (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRoleGroup() == null ? other.getRoleGroup() == null : this.getRoleGroup().equals(other.getRoleGroup()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRoleGroup() == null) ? 0 : getRoleGroup().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleName=").append(roleName);
        sb.append(", roleGroup=").append(roleGroup);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}