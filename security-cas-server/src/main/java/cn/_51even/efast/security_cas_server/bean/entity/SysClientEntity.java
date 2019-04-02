package cn._51even.efast.security_cas_server.bean.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_client")
public class SysClientEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 应用id
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * 应用密钥
     */
    @Column(name = "client_secret")
    private String clientSecret;

    /**
     * 授权类型
     */
    @Column(name = "grant_type")
    private String grantType;

    /**
     * 是否显式授权
     */
    @Column(name = "auto_approve")
    private Integer autoApprove;

    /**
     * 应用首页地址
     */
    @Column(name = "client_index_url")
    private String clientIndexUrl;

    /**
     * 授权成功重定向地址
     */
    @Column(name = "client_redirect_url")
    private String clientRedirectUrl;

    /**
     * 授权范围
     */
    private String scopes;

    /**
     * 应用图标
     */
    @Column(name = "client_icon")
    private String clientIcon;

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
     * 获取应用id
     *
     * @return client_id - 应用id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置应用id
     *
     * @param clientId 应用id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取应用密钥
     *
     * @return client_secret - 应用密钥
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * 设置应用密钥
     *
     * @param clientSecret 应用密钥
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * 获取授权类型
     *
     * @return grant_type - 授权类型
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * 设置授权类型
     *
     * @param grantType 授权类型
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    /**
     * 获取是否显式授权
     *
     * @return auto_approve - 是否显式授权
     */
    public Integer getAutoApprove() {
        return autoApprove;
    }

    /**
     * 设置是否显式授权
     *
     * @param autoApprove 是否显式授权
     */
    public void setAutoApprove(Integer autoApprove) {
        this.autoApprove = autoApprove;
    }

    /**
     * 获取应用首页地址
     *
     * @return client_index_url - 应用首页地址
     */
    public String getClientIndexUrl() {
        return clientIndexUrl;
    }

    /**
     * 设置应用首页地址
     *
     * @param clientIndexUrl 应用首页地址
     */
    public void setClientIndexUrl(String clientIndexUrl) {
        this.clientIndexUrl = clientIndexUrl;
    }

    /**
     * 获取授权成功重定向地址
     *
     * @return client_redirect_url - 授权成功重定向地址
     */
    public String getClientRedirectUrl() {
        return clientRedirectUrl;
    }

    /**
     * 设置授权成功重定向地址
     *
     * @param clientRedirectUrl 授权成功重定向地址
     */
    public void setClientRedirectUrl(String clientRedirectUrl) {
        this.clientRedirectUrl = clientRedirectUrl;
    }

    /**
     * 获取授权范围
     *
     * @return scopes - 授权范围
     */
    public String getScopes() {
        return scopes;
    }

    /**
     * 设置授权范围
     *
     * @param scopes 授权范围
     */
    public void setScopes(String scopes) {
        this.scopes = scopes;
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
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getClientSecret() == null ? other.getClientSecret() == null : this.getClientSecret().equals(other.getClientSecret()))
            && (this.getGrantType() == null ? other.getGrantType() == null : this.getGrantType().equals(other.getGrantType()))
            && (this.getAutoApprove() == null ? other.getAutoApprove() == null : this.getAutoApprove().equals(other.getAutoApprove()))
            && (this.getClientIndexUrl() == null ? other.getClientIndexUrl() == null : this.getClientIndexUrl().equals(other.getClientIndexUrl()))
            && (this.getClientRedirectUrl() == null ? other.getClientRedirectUrl() == null : this.getClientRedirectUrl().equals(other.getClientRedirectUrl()))
            && (this.getScopes() == null ? other.getScopes() == null : this.getScopes().equals(other.getScopes()))
            && (this.getClientIcon() == null ? other.getClientIcon() == null : this.getClientIcon().equals(other.getClientIcon()))
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
        result = prime * result + ((getClientSecret() == null) ? 0 : getClientSecret().hashCode());
        result = prime * result + ((getGrantType() == null) ? 0 : getGrantType().hashCode());
        result = prime * result + ((getAutoApprove() == null) ? 0 : getAutoApprove().hashCode());
        result = prime * result + ((getClientIndexUrl() == null) ? 0 : getClientIndexUrl().hashCode());
        result = prime * result + ((getClientRedirectUrl() == null) ? 0 : getClientRedirectUrl().hashCode());
        result = prime * result + ((getScopes() == null) ? 0 : getScopes().hashCode());
        result = prime * result + ((getClientIcon() == null) ? 0 : getClientIcon().hashCode());
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
        sb.append(", clientSecret=").append(clientSecret);
        sb.append(", grantType=").append(grantType);
        sb.append(", autoApprove=").append(autoApprove);
        sb.append(", clientIndexUrl=").append(clientIndexUrl);
        sb.append(", clientRedirectUrl=").append(clientRedirectUrl);
        sb.append(", scopes=").append(scopes);
        sb.append(", clientIcon=").append(clientIcon);
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