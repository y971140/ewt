package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.experimental.Accessors;

import java.util.Date;
@Accessors(chain=true)
@TableName	//实现了对象与表的映射关系 如果表名相同,则可以省略不写
public class Operator {
    /**
     * 菜单 ID
     */
    private Integer operatorId;

    /**
     * 所属菜单 ID
     */
    private Integer menuId;

    /**
     * 资源名称
     */
    private String operatorName;

    /**
     * 资源 URL
     */
    private String url;

    /**
     * 权限标识符
     */
    private String perms;

    /**
     * 资源需要的 HTTP 请求方法
     */
    private String httpMethod;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    public Operator(Integer operatorId, Integer menuId, String operatorName, String url, String perms, String httpMethod, Date createTime, Date modifyTime) {
        this.operatorId = operatorId;
        this.menuId = menuId;
        this.operatorName = operatorName;
        this.url = url;
        this.perms = perms;
        this.httpMethod = httpMethod;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Operator() {
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Operator)) return false;
        final Operator other = (Operator) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$operatorId = this.getOperatorId();
        final Object other$operatorId = other.getOperatorId();
        if (this$operatorId == null ? other$operatorId != null : !this$operatorId.equals(other$operatorId))
            return false;
        final Object this$menuId = this.getMenuId();
        final Object other$menuId = other.getMenuId();
        if (this$menuId == null ? other$menuId != null : !this$menuId.equals(other$menuId)) return false;
        final Object this$operatorName = this.getOperatorName();
        final Object other$operatorName = other.getOperatorName();
        if (this$operatorName == null ? other$operatorName != null : !this$operatorName.equals(other$operatorName))
            return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$perms = this.getPerms();
        final Object other$perms = other.getPerms();
        if (this$perms == null ? other$perms != null : !this$perms.equals(other$perms)) return false;
        final Object this$httpMethod = this.getHttpMethod();
        final Object other$httpMethod = other.getHttpMethod();
        if (this$httpMethod == null ? other$httpMethod != null : !this$httpMethod.equals(other$httpMethod))
            return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$modifyTime = this.getModifyTime();
        final Object other$modifyTime = other.getModifyTime();
        if (this$modifyTime == null ? other$modifyTime != null : !this$modifyTime.equals(other$modifyTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Operator;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $operatorId = this.getOperatorId();
        result = result * PRIME + ($operatorId == null ? 43 : $operatorId.hashCode());
        final Object $menuId = this.getMenuId();
        result = result * PRIME + ($menuId == null ? 43 : $menuId.hashCode());
        final Object $operatorName = this.getOperatorName();
        result = result * PRIME + ($operatorName == null ? 43 : $operatorName.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $perms = this.getPerms();
        result = result * PRIME + ($perms == null ? 43 : $perms.hashCode());
        final Object $httpMethod = this.getHttpMethod();
        result = result * PRIME + ($httpMethod == null ? 43 : $httpMethod.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $modifyTime = this.getModifyTime();
        result = result * PRIME + ($modifyTime == null ? 43 : $modifyTime.hashCode());
        return result;
    }

    public String toString() {
        return "Operator(operatorId=" + this.getOperatorId() + ", menuId=" + this.getMenuId() + ", operatorName=" + this.getOperatorName() + ", url=" + this.getUrl() + ", perms=" + this.getPerms() + ", httpMethod=" + this.getHttpMethod() + ", createTime=" + this.getCreateTime() + ", modifyTime=" + this.getModifyTime() + ")";
    }
}