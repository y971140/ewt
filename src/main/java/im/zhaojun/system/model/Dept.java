package im.zhaojun.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@ApiModel(value="Dept", description="部门表")
public class Dept implements Serializable {

    private static final long serialVersionUID = -194076170058276436L;

    /**
 	* 部门ID
	*/
    @JsonProperty("id")
    private Integer deptId;

    /**
	* 部门名称
	*/
    @JsonProperty("name")
    private String deptName;

    /**
	* 上级部门 ID
	*/
    private Integer parentId;

    /**
	* 排序
	*/
    private Integer orderNum;

    /**
	* 创建时间
	*/
    @JsonIgnore
    private Date createTime;

    /**
	* 修改时间
	*/
    @JsonIgnore
    private Date modifyTime;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Dept> children;

    public Dept() {
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<Dept> getChildren() {
        return children;
    }

    public void setChildren(List<Dept> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", parentId=" + parentId +
                ", orderNum=" + orderNum +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", children=" + children +
                '}';
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Dept)) return false;
        final Dept other = (Dept) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$deptId = this.getDeptId();
        final Object other$deptId = other.getDeptId();
        if (this$deptId == null ? other$deptId != null : !this$deptId.equals(other$deptId)) return false;
        final Object this$deptName = this.getDeptName();
        final Object other$deptName = other.getDeptName();
        if (this$deptName == null ? other$deptName != null : !this$deptName.equals(other$deptName)) return false;
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) return false;
        final Object this$orderNum = this.getOrderNum();
        final Object other$orderNum = other.getOrderNum();
        if (this$orderNum == null ? other$orderNum != null : !this$orderNum.equals(other$orderNum)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$modifyTime = this.getModifyTime();
        final Object other$modifyTime = other.getModifyTime();
        if (this$modifyTime == null ? other$modifyTime != null : !this$modifyTime.equals(other$modifyTime))
            return false;
        final Object this$children = this.getChildren();
        final Object other$children = other.getChildren();
        if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Dept;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $deptId = this.getDeptId();
        result = result * PRIME + ($deptId == null ? 43 : $deptId.hashCode());
        final Object $deptName = this.getDeptName();
        result = result * PRIME + ($deptName == null ? 43 : $deptName.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $orderNum = this.getOrderNum();
        result = result * PRIME + ($orderNum == null ? 43 : $orderNum.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $modifyTime = this.getModifyTime();
        result = result * PRIME + ($modifyTime == null ? 43 : $modifyTime.hashCode());
        final Object $children = this.getChildren();
        result = result * PRIME + ($children == null ? 43 : $children.hashCode());
        return result;
    }
}