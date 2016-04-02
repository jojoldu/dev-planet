package devplanet.model;

import javax.persistence.*;

/**
 * Created by jojoldu on 2016-04-02.
 */
@Entity
@Table(name="repository")
public class Repository {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private String hooks;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_idx")
    private User user;

    public Repository() {
    }

    public Repository(Integer id, String name, String hooks) {
        this.id = id;
        this.name = name;
        this.hooks = hooks;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
