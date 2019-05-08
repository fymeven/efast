package cn._51even.efast.security_sso_server.bean.request.sysResource;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sys_resource")
public class InsertSysResourceReq implements Serializable {
    /**
     * 上级资源
     */
    @ApiModelProperty(value = "上级资源",name = "parentId",required = true)
    private Integer parentId;

    /**
     * 资源名称
     */
    @ApiModelProperty(value = "资源名称",name = "resourceName",required = true)
    private String resourceName;

    /**
     * 资源类型
     */
    @ApiModelProperty(value = "资源类型",name = "resourceType",required = true)
    private Integer resourceType;

    /**
     * 资源图标
     */
    @ApiModelProperty(value = "资源图标",name = "resourceIcon",required = false)
    private String resourceIcon;

    /**
     * 资源链接地址
     */
    @ApiModelProperty(value = "资源链接地址",name = "resourceLink",required = false)
    private String resourceLink;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",name = "remark",required = false)
    private String remark;

    private static final long serialVersionUID = 1L;

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
        InsertSysResourceReq other = (InsertSysResourceReq) that;
        return
            (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getResourceName() == null ? other.getResourceName() == null : this.getResourceName().equals(other.getResourceName()))
            && (this.getResourceType() == null ? other.getResourceType() == null : this.getResourceType().equals(other.getResourceType()))
            && (this.getResourceIcon() == null ? other.getResourceIcon() == null : this.getResourceIcon().equals(other.getResourceIcon()))
            && (this.getResourceLink() == null ? other.getResourceLink() == null : this.getResourceLink().equals(other.getResourceLink()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getResourceName() == null) ? 0 : getResourceName().hashCode());
        result = prime * result + ((getResourceType() == null) ? 0 : getResourceType().hashCode());
        result = prime * result + ((getResourceIcon() == null) ? 0 : getResourceIcon().hashCode());
        result = prime * result + ((getResourceLink() == null) ? 0 : getResourceLink().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parentId=").append(parentId);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", resourceIcon=").append(resourceIcon);
        sb.append(", resourceLink=").append(resourceLink);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}