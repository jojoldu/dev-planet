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
    private String id;

    @Column(nullable = false)
    private String email;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    private List<Repository> repositories;

    public User() {
    }

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(String id, String email, List<Repository> repositories) {
        this.id = id;
        this.email = email;
        this.repositories = repositories;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
