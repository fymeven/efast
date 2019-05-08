package cn._51even.efast.security_sso_server.bean.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_client")
public class SysClientEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 应用名称
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * 应用图标
     */
    @Column(name = "client_icon")
    private String clientIcon;

    /**
     * 应用链接地址
     */
    @Column(name = "client_link")
    private String clientLink;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 应用状态
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
     * 获取应用名称
     *
     * @return client_name - 应用名称
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置应用名称
     *
     * @param clientName 应用名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取应用图标
     *
     * @return client_icon - 应用图标
     */
    public String getClientIcon() {
        return clientIcon;
    }

    /**
     * 设置应用图标
     *
     * @param clientIcon 应用图标
     */
    public void setClientIcon(String clientIcon) {
        this.clientIcon = clientIcon;
    }

    /**
     * 获取应用链接地址
     *
     * @return client_link - 应用链接地址
     */
    public String getClientLink() {
        return clientLink;
    }

    /**
     * 设置应用链接地址
     *
     * @param clientLink 应用链接地址
     */
    public void setClientLink(String clientLink) {
        this.clientLink = clientLink;
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
     * 获取应用状态
     *
     * @return status - 应用状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置应用状态
     *
     * @param status 应用状态
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
        SysClientEntity other = (SysClientEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientName() == null ? other.getClientName() == null : this.getClientName().equals(other.getClientName()))
            && (this.getClientIcon() == null ? other.getClientIcon() == null : this.getClientIcon().equals(other.getClientIcon()))
            && (this.getClientLink() == null ? other.getClientLink() == null : this.getClientLink().equals(other.getClientLink()))
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
        result = prime * result + ((getClientName() == null) ? 0 : getClientName().hashCode());
        result = prime * result + ((getClientIcon() == null) ? 0 : getClientIcon().hashCode());
        result = prime * result + ((getClientLink() == null) ? 0 : getClientLink().hashCode());
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
        sb.append(", clientName=").append(clientName);
        sb.append(", clientIcon=").append(clientIcon);
        sb.append(", clientLink=").append(clientLink);
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