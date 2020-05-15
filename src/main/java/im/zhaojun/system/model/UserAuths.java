package im.zhaojun.system.model;

/**
 * @author Zhao Jun
 * 2019/5/26 15:49
 */
public class UserAuths {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 登录类型
     */
    private String identityType;

    /**
     * 第三方登录的用户名
     */
    private String identifier;

    /**
     * 第三方登录 token
     */
    private String credential;

    public UserAuths() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserAuths)) return false;
        final UserAuths other = (UserAuths) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$identityType = this.getIdentityType();
        final Object other$identityType = other.getIdentityType();
        if (this$identityType == null ? other$identityType != null : !this$identityType.equals(other$identityType))
            return false;
        final Object this$identifier = this.getIdentifier();
        final Object other$identifier = other.getIdentifier();
        if (this$identifier == null ? other$identifier != null : !this$identifier.equals(other$identifier))
            return false;
        final Object this$credential = this.getCredential();
        final Object other$credential = other.getCredential();
        if (this$credential == null ? other$credential != null : !this$credential.equals(other$credential))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserAuths;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $identityType = this.getIdentityType();
        result = result * PRIME + ($identityType == null ? 43 : $identityType.hashCode());
        final Object $identifier = this.getIdentifier();
        result = result * PRIME + ($identifier == null ? 43 : $identifier.hashCode());
        final Object $credential = this.getCredential();
        result = result * PRIME + ($credential == null ? 43 : $credential.hashCode());
        return result;
    }

    public String toString() {
        return "UserAuths(id=" + this.getId() + ", userId=" + this.getUserId() + ", identityType=" + this.getIdentityType() + ", identifier=" + this.getIdentifier() + ", credential=" + this.getCredential() + ")";
    }
}