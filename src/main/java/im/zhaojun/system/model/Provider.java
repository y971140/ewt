package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ApiModel(value="Provider", description="供应商资料表")
@Accessors(chain = true)
public class Provider extends PublicModel {
    private static final long serialVersionUID = 7026922358123970623L;
    @TableId(type = IdType.AUTO)    //定义主键,主键自增
    private Long id;
    private String pid;
    //@TableField("pname")		//关联表字段,规则如果属性名称与字段名称一致则
    //可以省略不写(包含驼峰规则)
    @NotBlank(message = "供应商名称不能为空")
    private String pname;
    private String bankAccount;
    private String bankName;
    private Character genre;
    private String tel;
    @NotBlank(message = "手机号不能为空")
    //验证 String 对象是否符合正则表达式的规则
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确")
    private String mobile;
    @Email(message = "邮箱格式不正确")
    private String email;
    private String addr;
    private Integer abcSort;
    private Integer province;
    private Integer city;
    private Integer areas;
    private Integer isActivate;
    private String remark;
    private Integer isDel;

    public Provider(Long id, String pid, @NotBlank(message = "供应商名称不能为空") String pname, String bankAccount, String bankName, Character genre, String tel, @NotBlank(message = "手机号不能为空") @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确") String mobile, @Email(message = "邮箱格式不正确") String email, String addr, Integer abcSort, Integer province, Integer city, Integer areas, Integer isActivate, String remark, Integer isDel) {
        this.id = id;
        this.pid = pid;
        this.pname = pname;
        this.bankAccount = bankAccount;
        this.bankName = bankName;
        this.genre = genre;
        this.tel = tel;
        this.mobile = mobile;
        this.email = email;
        this.addr = addr;
        this.abcSort = abcSort;
        this.province = province;
        this.city = city;
        this.areas = areas;
        this.isActivate = isActivate;
        this.remark = remark;
        this.isDel = isDel;
    }

    public Provider() {
    }
    public Long getId() {
        return this.id;
    }

    public String getPid() {
        return this.pid;
    }

    public @NotBlank(message = "供应商名称不能为空") String getPname() {
        return this.pname;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public String getBankName() {
        return this.bankName;
    }

    public Character getGenre() {
        return this.genre;
    }

    public String getTel() {
        return this.tel;
    }

    public @NotBlank(message = "手机号不能为空") @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确") String getMobile() {
        return this.mobile;
    }

    public @Email(message = "邮箱格式不正确") String getEmail() {
        return this.email;
    }

    public String getAddr() {
        return this.addr;
    }

    public Integer getAbcSort() {
        return this.abcSort;
    }

    public Integer getProvince() {
        return this.province;
    }

    public Integer getCity() {
        return this.city;
    }

    public Integer getAreas() {
        return this.areas;
    }

    public Integer getIsActivate() {
        return this.isActivate;
    }

    public String getRemark() {
        return this.remark;
    }

    public Integer getIsDel() {
        return this.isDel;
    }

    public Provider setId(Long id) {
        this.id = id;
        return this;
    }

    public Provider setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public Provider setPname(@NotBlank(message = "供应商名称不能为空") String pname) {
        this.pname = pname;
        return this;
    }

    public Provider setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public Provider setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public Provider setGenre(Character genre) {
        this.genre = genre;
        return this;
    }

    public Provider setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public Provider setMobile(@NotBlank(message = "手机号不能为空") @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确") String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Provider setEmail(@Email(message = "邮箱格式不正确") String email) {
        this.email = email;
        return this;
    }

    public Provider setAddr(String addr) {
        this.addr = addr;
        return this;
    }

    public Provider setAbcSort(Integer abcSort) {
        this.abcSort = abcSort;
        return this;
    }

    public Provider setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Provider setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Provider setAreas(Integer areas) {
        this.areas = areas;
        return this;
    }

    public Provider setIsActivate(Integer isActivate) {
        this.isActivate = isActivate;
        return this;
    }

    public Provider setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Provider setIsDel(Integer isDel) {
        this.isDel = isDel;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Provider)) return false;
        final Provider other = (Provider) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$pid = this.getPid();
        final Object other$pid = other.getPid();
        if (this$pid == null ? other$pid != null : !this$pid.equals(other$pid)) return false;
        final Object this$pname = this.getPname();
        final Object other$pname = other.getPname();
        if (this$pname == null ? other$pname != null : !this$pname.equals(other$pname)) return false;
        final Object this$bankAccount = this.getBankAccount();
        final Object other$bankAccount = other.getBankAccount();
        if (this$bankAccount == null ? other$bankAccount != null : !this$bankAccount.equals(other$bankAccount))
            return false;
        final Object this$bankName = this.getBankName();
        final Object other$bankName = other.getBankName();
        if (this$bankName == null ? other$bankName != null : !this$bankName.equals(other$bankName)) return false;
        final Object this$genre = this.getGenre();
        final Object other$genre = other.getGenre();
        if (this$genre == null ? other$genre != null : !this$genre.equals(other$genre)) return false;
        final Object this$tel = this.getTel();
        final Object other$tel = other.getTel();
        if (this$tel == null ? other$tel != null : !this$tel.equals(other$tel)) return false;
        final Object this$mobile = this.getMobile();
        final Object other$mobile = other.getMobile();
        if (this$mobile == null ? other$mobile != null : !this$mobile.equals(other$mobile)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$addr = this.getAddr();
        final Object other$addr = other.getAddr();
        if (this$addr == null ? other$addr != null : !this$addr.equals(other$addr)) return false;
        final Object this$abcSort = this.getAbcSort();
        final Object other$abcSort = other.getAbcSort();
        if (this$abcSort == null ? other$abcSort != null : !this$abcSort.equals(other$abcSort)) return false;
        final Object this$province = this.getProvince();
        final Object other$province = other.getProvince();
        if (this$province == null ? other$province != null : !this$province.equals(other$province)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$areas = this.getAreas();
        final Object other$areas = other.getAreas();
        if (this$areas == null ? other$areas != null : !this$areas.equals(other$areas)) return false;
        final Object this$isActivate = this.getIsActivate();
        final Object other$isActivate = other.getIsActivate();
        if (this$isActivate == null ? other$isActivate != null : !this$isActivate.equals(other$isActivate))
            return false;
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark)) return false;
        final Object this$isDel = this.getIsDel();
        final Object other$isDel = other.getIsDel();
        if (this$isDel == null ? other$isDel != null : !this$isDel.equals(other$isDel)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Provider;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $pid = this.getPid();
        result = result * PRIME + ($pid == null ? 43 : $pid.hashCode());
        final Object $pname = this.getPname();
        result = result * PRIME + ($pname == null ? 43 : $pname.hashCode());
        final Object $bankAccount = this.getBankAccount();
        result = result * PRIME + ($bankAccount == null ? 43 : $bankAccount.hashCode());
        final Object $bankName = this.getBankName();
        result = result * PRIME + ($bankName == null ? 43 : $bankName.hashCode());
        final Object $genre = this.getGenre();
        result = result * PRIME + ($genre == null ? 43 : $genre.hashCode());
        final Object $tel = this.getTel();
        result = result * PRIME + ($tel == null ? 43 : $tel.hashCode());
        final Object $mobile = this.getMobile();
        result = result * PRIME + ($mobile == null ? 43 : $mobile.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $addr = this.getAddr();
        result = result * PRIME + ($addr == null ? 43 : $addr.hashCode());
        final Object $abcSort = this.getAbcSort();
        result = result * PRIME + ($abcSort == null ? 43 : $abcSort.hashCode());
        final Object $province = this.getProvince();
        result = result * PRIME + ($province == null ? 43 : $province.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $areas = this.getAreas();
        result = result * PRIME + ($areas == null ? 43 : $areas.hashCode());
        final Object $isActivate = this.getIsActivate();
        result = result * PRIME + ($isActivate == null ? 43 : $isActivate.hashCode());
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        final Object $isDel = this.getIsDel();
        result = result * PRIME + ($isDel == null ? 43 : $isDel.hashCode());
        return result;
    }

    public String toString() {
        return "Provider(id=" + this.getId() + ", pid=" + this.getPid() + ", pname=" + this.getPname() + ", bankAccount=" + this.getBankAccount() + ", bankName=" + this.getBankName() + ", genre=" + this.getGenre() + ", tel=" + this.getTel() + ", mobile=" + this.getMobile() + ", email=" + this.getEmail() + ", addr=" + this.getAddr() + ", abcSort=" + this.getAbcSort() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ", areas=" + this.getAreas() + ", isActivate=" + this.getIsActivate() + ", remark=" + this.getRemark() + ", isDel=" + this.getIsDel() + ")";
    }
}
