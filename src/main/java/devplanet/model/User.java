package devplanet.model;

import devplanet.oauth2.GithubUser;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-04-01.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column
    private Integer githubIdx;

    @Column
    private String userName;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    private List<Repository> repositories;

    @Column(name="last_check_date")
    private DateTime lastCheckDate;

    @Column(name="current_streak")
    private int currentStreak;

    @Column(name="point")
    private int point;

    public User() {
    }

    public User(GithubUser githubUser) {
        this.githubIdx = githubUser.getId();
        this.userName = githubUser.getLogin();
    }

    public User(Integer githubIdx, String userName, DateTime lastCheckDate, int currentStreak, int point) {
        this.githubIdx = githubIdx;
        this.userName = userName;
        this.lastCheckDate = lastCheckDate;
        this.currentStreak = currentStreak;
        this.point = point;
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

    public DateTime getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(DateTime lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
