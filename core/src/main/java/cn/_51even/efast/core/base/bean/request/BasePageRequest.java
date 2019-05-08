package cn._51even.efast.core.base.bean.request;

import cn._51even.efast.core.base.exception.BusinessException;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Min;

public class BasePageRequest {

    @ApiModelProperty(value = "是否分页",name = "doPage")
    private Boolean doPage;

    @ApiModelProperty(value = "请求分页页码",name = "pageNum")
    @Min(value = 1,message = "页数最少为1")
    private Integer pageNum;

    @ApiModelProperty(value = "请求每页分页数据量",name = "pageSize")
    @Min(value = 1,message = "每页分页数据量最少为1")
    private Integer pageSize;

    @ApiModelProperty(value = "分页偏移量",name = "offsetNum",hidden = true)
    private Integer offsetNum;

    @ApiModelProperty(value = "是否排序",name = "doSort")
    private Boolean doSort;

    @ApiModelProperty(value = "排序字段",name = "sortColumn")
    private String sortColumn;

    @ApiModelProperty(value = "排序规则：ASC / DESC",name = "sortRule")
    private String sortRule;

    @ApiModelProperty(hidden = true)
    private String orderBy;

    public Boolean getDoPage() {
        if (this.doPage == null){
            this.doPage = true;
        }
        return this.doPage;
    }

    public void setDoPage(Boolean doPage) {
        this.doPage = doPage;
    }

    public Integer getPageNum() {
        if (this.pageNum == null || this.pageNum < 1){
            this.pageNum = 1;
        }
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize < 1){
            this.pageSize = 20;
        }
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffsetNum() {
        if (this.offsetNum == null){
            this.offsetNum = (this.getPageNum() - 1) * this.getPageSize();
        }
        return offsetNum;
    }

    public void setOffsetNum(Integer offsetNum) {
        this.offsetNum = offsetNum;
    }

    public Boolean getDoSort() {
        if (this.doSort == null){
            this.doSort = true;
        }
        return this.doSort;
    }

    public void setDoSort(Boolean doSort) {
        this.doSort = doSort;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortRule() {
        if (this.getDoSort()){
            this.sortRule= StringUtils.isBlank(this.sortRule) ? "DESC" : this.sortRule.toUpperCase();
        }
        return this.sortRule;
    }

    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
    }

    public String getOrderBy() {
        if (StringUtils.isBlank(this.orderBy)){
            if (this.getDoSort()){
                if (StringUtils.isBlank(this.sortColumn)){
                    throw new BusinessException("当前方法已启用排序,但未指定排序字段[sortColumn]");
                }
                this.orderBy = this.getSortColumn()+"\t"+this.getSortRule();
            }
        }
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }



}
