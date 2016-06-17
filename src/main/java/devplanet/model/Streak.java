package devplanet.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-27.
 */

@Entity
@Table(name="streak")
public class Streak {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column(name="last_check_date")
    private DateTime lastCheckDate;

    @Column(name="current")
    private int current;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_idx")
    private User user;

    public Streak() {
    }

    public Streak(DateTime lastCheckDate, int current) {
        this.lastCheckDate = lastCheckDate;
        this.current = current;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Streak(String lastYear, DateTime lastCheckDate, int current) {
        this.lastCheckDate = lastCheckDate;
        this.current = current;
    }

    public DateTime getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(DateTime lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
