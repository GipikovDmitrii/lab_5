package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlAttribute(name = "id")
    private int id;
    @XmlTransient
    private String login;
    @XmlTransient
    private String password;
    @XmlTransient
    private String email;
    @XmlTransient
    private Role role;

    @XmlElementWrapper(name = "tasks")
    @XmlElement(name = "task", type = Task.class)
    private List<Task> taskList = new ArrayList<>();

    public User() {
    }

    public User(int id, String login, String password, String email, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }

    public static class Role {

        private int id;
        private String role;

        public Role() {
        }

        public Role(int id) {
            this.id = id;
        }

        public Role(String role) {
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
            Role role1 = (Role) o;
            return id == role1.id &&
                    Objects.equals(role, role1.role);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, role);
        }
    }
}
