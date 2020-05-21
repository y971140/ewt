package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Accessors(chain = true)
@TableName    //实现了对象与表的映射关系 如果表名相同,则可以省略不写
@Data
public class PublicModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3156133242285166478L;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_id", fill = FieldFill.INSERT)
    private Integer createId;
    @TableField(fill = FieldFill.INSERT)
    private String createName;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateId;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateName;
    public PublicModel(Date createTime, Integer createId, String createName, Date updateTime, Integer updateId, String updateName) {
        this.createTime = createTime;
        this.createId = createId;
        this.createName = createName;
        this.updateTime = updateTime;
        this.updateId = updateId;
        this.updateName = updateName;
    }

    public PublicModel() {
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Integer getCreateId() {
        return this.createId;
    }

    public String getCreateName() {
        return this.createName;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Integer getUpdateId() {
        return this.updateId;
    }

    public String getUpdateName() {
        return this.updateName;
    }
    public PublicModel setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public PublicModel setCreateId(Integer createId) {
        this.createId = createId;
        return this;
    }

    public PublicModel setCreateName(String createName) {
        this.createName = createName;
        return this;
    }

    public PublicModel setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public PublicModel setUpdateId(Integer updateId) {
        this.updateId = updateId;
        return this;
    }

    public PublicModel setUpdateName(String updateName) {
        this.updateName = updateName;
        return this;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PublicModel)) return false;
        final PublicModel other = (PublicModel) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$createId = this.getCreateId();
        final Object other$createId = other.getCreateId();
        if (this$createId == null ? other$createId != null : !this$createId.equals(other$createId)) return false;
        final Object this$createName = this.getCreateName();
        final Object other$createName = other.getCreateName();
        if (this$createName == null ? other$createName != null : !this$createName.equals(other$createName))
            return false;
        final Object this$updateTime = this.getUpdateTime();
        final Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime))
            return false;
        final Object this$updateId = this.getUpdateId();
        final Object other$updateId = other.getUpdateId();
        if (this$updateId == null ? other$updateId != null : !this$updateId.equals(other$updateId)) return false;
        final Object this$updateName = this.getUpdateName();
        final Object other$updateName = other.getUpdateName();
        if (this$updateName == null ? other$updateName != null : !this$updateName.equals(other$updateName))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PublicModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $createId = this.getCreateId();
        result = result * PRIME + ($createId == null ? 43 : $createId.hashCode());
        final Object $createName = this.getCreateName();
        result = result * PRIME + ($createName == null ? 43 : $createName.hashCode());
        final Object $updateTime = this.getUpdateTime();
        result = result * PRIME + ($updateTime == null ? 43 : $updateTime.hashCode());
        final Object $updateId = this.getUpdateId();
        result = result * PRIME + ($updateId == null ? 43 : $updateId.hashCode());
        final Object $updateName = this.getUpdateName();
        result = result * PRIME + ($updateName == null ? 43 : $updateName.hashCode());
        return result;
    }
    public String toString() {
        return "PublicModel(createTime=" + this.getCreateTime() + ", createId=" + this.getCreateId() + ", createName=" + this.getCreateName() + ", updateTime=" + this.getUpdateTime() + ", updateId=" + this.getUpdateId() + ", updateName=" + this.getUpdateName() +  ")";
    }
}
