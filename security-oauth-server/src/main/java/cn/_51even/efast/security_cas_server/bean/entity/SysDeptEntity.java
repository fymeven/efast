package cn._51even.efast.security_sso_server.bean.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_dept")
public class SysDeptEntity implements Serializable {
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 部门编码
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 部门类型
     */
    @Column(name = "dept_type")
    private String deptType;

    /**
     * 部门领导用户id
     */
    @Column(name = "dept_leader_id")
    private String deptLeaderId;

    /**
     * 上级编码
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 部门状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门编码
     *
     * @return dept_code - 部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门编码
     *
     * @param deptCode 部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取部门类型
     *
     * @return dept_type - 部门类型
     */
    public String getDeptType() {
        return deptType;
    }

    /**
     * 设置部门类型
     *
     * @param deptType 部门类型
     */
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    /**
     * 获取部门领导用户id
     *
     * @return dept_leader_id - 部门领导用户id
     */
    public String getDeptLeaderId() {
        return deptLeaderId;
    }

    /**
     * 设置部门领导用户id
     *
     * @param deptLeaderId 部门领导用户id
     */
    public void setDeptLeaderId(String deptLeaderId) {
        this.deptLeaderId = deptLeaderId;
    }

    /**
     * 获取上级编码
     *
     * @return parent_code - 上级编码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置上级编码
     *
     * @param parentCode 上级编码
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 获取部门状态
     *
     * @return status - 部门状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置部门状态
     *
     * @param status 部门状态
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        SysDeptEntity other = (SysDeptEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDeptType() == null ? other.getDeptType() == null : this.getDeptType().equals(other.getDeptType()))
            && (this.getDeptLeaderId() == null ? other.getDeptLeaderId() == null : this.getDeptLeaderId().equals(other.getDeptLeaderId()))
            && (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDeptType() == null) ? 0 : getDeptType().hashCode());
        result = prime * result + ((getDeptLeaderId() == null) ? 0 : getDeptLeaderId().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deptCode=").append(deptCode);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptType=").append(deptType);
        sb.append(", deptLeaderId=").append(deptLeaderId);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}