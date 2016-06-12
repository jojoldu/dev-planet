package devplanet.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-01.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    private List<Repository> repositories;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Streak streak;

    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public User(String userName, String email, List<Repository> repositories) {
        this.userName = userName;
        this.email = email;
        this.repositories = repositories;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public Streak getStreak() {
        return streak;
    }

    public void setStreak(Streak streak) {
        this.streak = streak;
    }
}
