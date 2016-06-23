package devplanet.model;

import devplanet.oauth2.GithubUser;

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

    @Column
    private Integer githubIdx;

    @Column
    private String userName;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    private List<Repository> repositories;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Streak streak;

    public User() {
    }

    public User(GithubUser githubUser) {
        this.githubIdx = githubUser.getId();
        this.userName = githubUser.getLogin();
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getGithubIdx() {
        return githubIdx;
    }

    public void setGithubIdx(Integer githubIdx) {
        this.githubIdx = githubIdx;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "User{" +
                "idx=" + idx +
                ", githubIdx=" + githubIdx +
                ", userName='" + userName + '\'' +
                ", repositories=" + repositories +
                ", streak=" + streak +
                '}';
    }
}
