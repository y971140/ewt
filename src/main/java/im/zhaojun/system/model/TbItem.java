package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author maqh
 * @since 2020-04-19
 */
@Accessors(chain = true)
@ApiModel(value="TbItem对象", description="商品表")
public class TbItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id，同时也是商品编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品标题")
    private String title;

    @ApiModelProperty(value = "商品卖点")
    private String sellPoint;

    @ApiModelProperty(value = "商品价格，单位为：分")
    private Long price;

    @ApiModelProperty(value = "库存数量")
    private Integer num;

    @ApiModelProperty(value = "商品条形码")
    private String barcode;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "所属类目，叶子类目")
    private Long cid;

    @ApiModelProperty(value = "商品状态，1-正常，2-下架，3-删除")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public TbItem() {
    }


    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSellPoint() {
        return this.sellPoint;
    }

    public Long getPrice() {
        return this.price;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public String getImage() {
        return this.image;
    }

    public Long getCid() {
        return this.cid;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public TbItem setId(Long id) {
        this.id = id;
        return this;
    }

    public TbItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public TbItem setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
        return this;
    }

    public TbItem setPrice(Long price) {
        this.price = price;
        return this;
    }

    public TbItem setNum(Integer num) {
        this.num = num;
        return this;
    }

    public TbItem setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public TbItem setImage(String image) {
        this.image = image;
        return this;
    }

    public TbItem setCid(Long cid) {
        this.cid = cid;
        return this;
    }

    public TbItem setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public TbItem setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public TbItem setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "TbItem(id=" + this.getId() + ", title=" + this.getTitle() + ", sellPoint=" + this.getSellPoint() + ", price=" + this.getPrice() + ", num=" + this.getNum() + ", barcode=" + this.getBarcode() + ", image=" + this.getImage() + ", cid=" + this.getCid() + ", status=" + this.getStatus() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TbItem)) return false;
        final TbItem other = (TbItem) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$sellPoint = this.getSellPoint();
        final Object other$sellPoint = other.getSellPoint();
        if (this$sellPoint == null ? other$sellPoint != null : !this$sellPoint.equals(other$sellPoint)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$num = this.getNum();
        final Object other$num = other.getNum();
        if (this$num == null ? other$num != null : !this$num.equals(other$num)) return false;
        final Object this$barcode = this.getBarcode();
        final Object other$barcode = other.getBarcode();
        if (this$barcode == null ? other$barcode != null : !this$barcode.equals(other$barcode)) return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        final Object this$cid = this.getCid();
        final Object other$cid = other.getCid();
        if (this$cid == null ? other$cid != null : !this$cid.equals(other$cid)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$updateTime = this.getUpdateTime();
        final Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TbItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $sellPoint = this.getSellPoint();
        result = result * PRIME + ($sellPoint == null ? 43 : $sellPoint.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $num = this.getNum();
        result = result * PRIME + ($num == null ? 43 : $num.hashCode());
        final Object $barcode = this.getBarcode();
        result = result * PRIME + ($barcode == null ? 43 : $barcode.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        final Object $cid = this.getCid();
        result = result * PRIME + ($cid == null ? 43 : $cid.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $updateTime = this.getUpdateTime();
        result = result * PRIME + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}
