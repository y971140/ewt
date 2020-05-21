package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hill
 * @since 2020-05-22
 */
@Data
@TableName("organ")
public class Organ extends Model<Organ> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 机构名称
     */
    @TableField("organ_name")
    private String organName;

    /**
     * 机构简称
     */
    @TableField("abbreviation")
    private String abbreviation;

    /**
     * 机构电话
     */
    @TableField("otel")
    private String otel;

    /**
     * 打印信息头
     */
    @TableField("organ_printa")
    private String organPrinta;

    /**
     * 打印信息尾
     */
    @TableField("organ_printb")
    private String organPrintb;

    /**
     * 打印信息尾
     */
    @TableField("organ_printc")
    private String organPrintc;

    /**
     * 打印信息尾
     */
    @TableField("organ_printd")
    private String organPrintd;

    /**
     * 打印信息尾
     */
    @TableField("organ_printe")
    private String organPrinte;

    /**
     * 打印信息尾
     */
    @TableField("organ_printf")
    private String organPrintf;

    /**
     * 上级机构ID
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 机构等级
     */
    @TableField("rank")
    private Integer rank;

    /**
     * 省
     */
    @TableField("province")
    private Integer province;

    /**
     * 市
     */
    @TableField("city")
    private Integer city;

    /**
     * 区
     */
    @TableField("areas")
    private Integer areas;

    /**
     * 地址
     */
    @TableField("addr")
    private String addr;

    /**
     * 是否为默认配送机构
     */
    @TableField("is_default_equip_organ")
    private Integer isDefaultEquipOrgan;

    /**
     * 机构价格类型
     */
    @TableField("price_type")
    private String priceType;

    /**
     * 是否可用，1可用，0不可用
     */
    @TableField("use_flag")
    private Integer useFlag;

    /**
     * 积分倍率
     */
    @TableField("integral_rate")
    private Double integralRate;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人ID
     */
    @TableField("create_id")
    private Integer createId;

    /**
     * 创建人名称
     */
    @TableField("create_name")
    private String createName;

    /**
     * 机构类型
     */
    @TableField("organ_type")
    private Integer organType;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 更新人ID
     */
    @TableField("update_id")
    private Integer updateId;

    /**
     * 更新人名称
     */
    @TableField("update_name")
    private String updateName;

    /**
     * 版本
     */
    @TableField("version")
    private Blob version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
