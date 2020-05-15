package im.zhaojun.system.model;

import java.io.Serializable;
import java.util.Date;
public class UserOnline implements Serializable {

    private static final long serialVersionUID = 3828664348416633856L;

    private String id;
    private Integer userId;
    private String username;
    private String ip;
    private String status;
    private Date startTimestamp;
    private Date lastAccessTime;
    private Long timeout;

    public UserOnline() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserOnline)) return false;
        final UserOnline other = (UserOnline) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$ip = this.getIp();
        final Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$startTimestamp = this.getStartTimestamp();
        final Object other$startTimestamp = other.getStartTimestamp();
        if (this$startTimestamp == null ? other$startTimestamp != null : !this$startTimestamp.equals(other$startTimestamp))
            return false;
        final Object this$lastAccessTime = this.getLastAccessTime();
        final Object other$lastAccessTime = other.getLastAccessTime();
        if (this$lastAccessTime == null ? other$lastAccessTime != null : !this$lastAccessTime.equals(other$lastAccessTime))
            return false;
        final Object this$timeout = this.getTimeout();
        final Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserOnline;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $ip = this.getIp();
        result = result * PRIME + ($ip == null ? 43 : $ip.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $startTimestamp = this.getStartTimestamp();
        result = result * PRIME + ($startTimestamp == null ? 43 : $startTimestamp.hashCode());
        final Object $lastAccessTime = this.getLastAccessTime();
        result = result * PRIME + ($lastAccessTime == null ? 43 : $lastAccessTime.hashCode());
        final Object $timeout = this.getTimeout();
        result = result * PRIME + ($timeout == null ? 43 : $timeout.hashCode());
        return result;
    }

    public String toString() {
        return "UserOnline(id=" + this.getId() + ", userId=" + this.getUserId() + ", username=" + this.getUsername() + ", ip=" + this.getIp() + ", status=" + this.getStatus() + ", startTimestamp=" + this.getStartTimestamp() + ", lastAccessTime=" + this.getLastAccessTime() + ", timeout=" + this.getTimeout() + ")";
    }
}
