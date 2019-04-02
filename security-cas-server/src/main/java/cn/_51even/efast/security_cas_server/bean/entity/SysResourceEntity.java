package cn._51even.efast.security_cas_server.bean.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_resource")
public class SysResourceEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 所属应用id
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * 上级资源
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 资源名称
     */
    @Column(name = "resource_name")
    private String resourceName;

    /**
     * 资源类型
     */
    @Column(name = "resource_type")
    private Integer resourceType;

    /**
     * 资源图标
     */
    @Column(name = "resource_icon")
    private String resourceIcon;

    /**
     * 资源链接地址
     */
    @Column(name = "resource_link")
    private String resourceLink;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 资源状态
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
     * 获取所属应用id
     *
     * @return client_id - 所属应用id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置所属应用id
     *
     * @param clientId 所属应用id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取上级资源
     *
     * @return parent_id - 上级资源
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级资源
     *
     * @param parentId 上级资源
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取资源名称
     *
     * @return resource_name - 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名称
     *
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取资源类型
     *
     * @return resource_type - 资源类型
     */
    public Integer getResourceType() {
        return resourceType;
    }

    /**
     * 设置资源类型
     *
     * @param resourceType 资源类型
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取资源图标
     *
     * @return resource_icon - 资源图标
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * 设置资源图标
     *
     * @param resourceIcon 资源图标
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    /**
     * 获取资源链接地址
     *
     * @return resource_link - 资源链接地址
     */
    public String getResourceLink() {
        return resourceLink;
    }

    /**
     * 设置资源链接地址
     *
     * @param resourceLink 资源链接地址
     */
    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    /**
     * 获取权重
     *
     * @return weight - 权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重
     *
     * @param weight 权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取资源状态
     *
     * @return status - 资源状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置资源状态
     *
     * @param status 资源状态
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
        SysResourceEntity other = (SysResourceEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getResourceName() == null ? other.getResourceName() == null : this.getResourceName().equals(other.getResourceName()))
            && (this.getResourceType() == null ? other.getResourceType() == null : this.getResourceType().equals(other.getResourceType()))
            && (this.getResourceIcon() == null ? other.getResourceIcon() == null : this.getResourceIcon().equals(other.getResourceIcon()))
            && (this.getResourceLink() == null ? other.getResourceLink() == null : this.getResourceLink().equals(other.getResourceLink()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
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
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getResourceName() == null) ? 0 : getResourceName().hashCode());
        result = prime * result + ((getResourceType() == null) ? 0 : getResourceType().hashCode());
        result = prime * result + ((getResourceIcon() == null) ? 0 : getResourceIcon().hashCode());
        result = prime * result + ((getResourceLink() == null) ? 0 : getResourceLink().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
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
        sb.append(", clientId=").append(clientId);
        sb.append(", parentId=").append(parentId);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", resourceIcon=").append(resourceIcon);
        sb.append(", resourceLink=").append(resourceLink);
        sb.append(", weight=").append(weight);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}