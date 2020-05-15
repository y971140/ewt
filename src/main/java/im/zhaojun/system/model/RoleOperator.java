package im.zhaojun.system.model;

public class RoleOperator {
    private Integer roleId;

    private Integer operatorId;

    public RoleOperator() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleOperator)) return false;
        final RoleOperator other = (RoleOperator) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        final Object this$operatorId = this.getOperatorId();
        final Object other$operatorId = other.getOperatorId();
        if (this$operatorId == null ? other$operatorId != null : !this$operatorId.equals(other$operatorId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoleOperator;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        final Object $operatorId = this.getOperatorId();
        result = result * PRIME + ($operatorId == null ? 43 : $operatorId.hashCode());
        return result;
    }

    public String toString() {
        return "RoleOperator(roleId=" + this.getRoleId() + ", operatorId=" + this.getOperatorId() + ")";
    }
}