package cl.nissum.register.data.datasource.impl.database.model;




import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Table(name = "user")
@Entity
public class UserDataBaseModel {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token", nullable = true)
    private String token;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "modified", nullable = true)
    private  Timestamp modified;

    @Column(name = "last_login", nullable = true)
    private  Timestamp lastLogin;

    @Column(name = "active", nullable = true)
    private  boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneDataBaseModel> phones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<PhoneDataBaseModel> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDataBaseModel> phones) {
        this.phones = phones;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}