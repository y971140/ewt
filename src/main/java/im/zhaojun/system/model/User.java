package im.zhaojun.system.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "user", description = "用户表")
public class User extends  PublicModel implements Serializable {
    private static final long serialVersionUID = -5936948512954961199L;
    private Integer userId;
    @NotBlank(message = "用户名不能为空")
    @TableField(fill = FieldFill.UPDATE)
    private String username;
    @NotBlank(message = "姓名不能为空")
    private String fullname;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String salt;
    @Email(message = "邮箱格式不正确")
    private String email;
    private String status;
    private Date lastLoginTime;

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private Date modifyTime;

    @JsonIgnore
    private String activeCode;

    private Integer deptId;

    private String deptName;

    public User() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$fullname = this.getFullname();
        final Object other$fullname = other.getFullname();
        if (this$fullname == null ? other$fullname != null : !this$fullname.equals(other$fullname)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$salt = this.getSalt();
        final Object other$salt = other.getSalt();
        if (this$salt == null ? other$salt != null : !this$salt.equals(other$salt)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$lastLoginTime = this.getLastLoginTime();
        final Object other$lastLoginTime = other.getLastLoginTime();
        if (this$lastLoginTime == null ? other$lastLoginTime != null : !this$lastLoginTime.equals(other$lastLoginTime))
            return false;
        final Object this$activeCode = this.getActiveCode();
        final Object other$activeCode = other.getActiveCode();
        if (this$activeCode == null ? other$activeCode != null : !this$activeCode.equals(other$activeCode))
            return false;
        final Object this$deptId = this.getDeptId();
        final Object other$deptId = other.getDeptId();
        if (this$deptId == null ? other$deptId != null : !this$deptId.equals(other$deptId)) return false;
        final Object this$deptName = this.getDeptName();
        final Object other$deptName = other.getDeptName();
        if (this$deptName == null ? other$deptName != null : !this$deptName.equals(other$deptName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $fullname = this.getFullname();
        result = result * PRIME + ($fullname == null ? 43 : $fullname.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $salt = this.getSalt();
        result = result * PRIME + ($salt == null ? 43 : $salt.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $lastLoginTime = this.getLastLoginTime();
        result = result * PRIME + ($lastLoginTime == null ? 43 : $lastLoginTime.hashCode());
        final Object $activeCode = this.getActiveCode();
        result = result * PRIME + ($activeCode == null ? 43 : $activeCode.hashCode());
        final Object $deptId = this.getDeptId();
        result = result * PRIME + ($deptId == null ? 43 : $deptId.hashCode());
        final Object $deptName = this.getDeptName();
        result = result * PRIME + ($deptName == null ? 43 : $deptName.hashCode());
        return result;
    }
}