package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserRolesPK implements Serializable {
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "role")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesPK that = (UserRolesPK) o;

        if (userId != that.userId) return false;
        return Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
