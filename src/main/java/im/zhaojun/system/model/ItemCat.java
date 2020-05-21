package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
@Data
@ApiModel(value = "ItemCat", description = "商品类目表")
@TableName("tb_item_cat")
@Accessors(chain = true)
public class ItemCat {
    @TableId(type = IdType.AUTO)    //主键自增
    private Integer id;
    private Integer parentId;    //父级ID
    private String name;
    private Integer status;
    private Integer sortOrder;    //排序号
    private Boolean isParent;    //是否为父级 true  false
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ItemCat> children;
}