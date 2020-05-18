package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.experimental.Accessors;
@ApiModel(value="ItemCat", description="商品类目表")
@TableName("tb_item_cat")
@Accessors(chain=true)
public class ItemCat {
	@TableId(type=IdType.AUTO)	//主键自增
	private Long id;
	private Long parentId;	//父级ID
	private String name;
	private Integer status;
	private Integer sortOrder;	//排序号
	private Boolean isParent;	//是否为父级 true  false

    public ItemCat() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public String getName() {
        return this.name;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public Boolean getIsParent() {
        return this.isParent;
    }

    public ItemCat setId(Long id) {
        this.id = id;
        return this;
    }

    public ItemCat setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public ItemCat setName(String name) {
        this.name = name;
        return this;
    }

    public ItemCat setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ItemCat setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public ItemCat setIsParent(Boolean isParent) {
        this.isParent = isParent;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ItemCat)) return false;
        final ItemCat other = (ItemCat) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$sortOrder = this.getSortOrder();
        final Object other$sortOrder = other.getSortOrder();
        if (this$sortOrder == null ? other$sortOrder != null : !this$sortOrder.equals(other$sortOrder)) return false;
        final Object this$isParent = this.getIsParent();
        final Object other$isParent = other.getIsParent();
        if (this$isParent == null ? other$isParent != null : !this$isParent.equals(other$isParent)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemCat;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $sortOrder = this.getSortOrder();
        result = result * PRIME + ($sortOrder == null ? 43 : $sortOrder.hashCode());
        final Object $isParent = this.getIsParent();
        result = result * PRIME + ($isParent == null ? 43 : $isParent.hashCode());
        return result;
    }

    public String toString() {
        return "ItemCat(id=" + this.getId() + ", parentId=" + this.getParentId() + ", name=" + this.getName() + ", status=" + this.getStatus() + ", sortOrder=" + this.getSortOrder() + ", isParent=" + this.getIsParent() + ")";
    }
}