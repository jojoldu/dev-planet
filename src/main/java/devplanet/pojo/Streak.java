package devplanet.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Streak {
    private String lastYear;
    private String longest;
    private String current;

    public static Streak NULL_STREAK = new Streak(null,null,null);

    public Streak(String lastYear, String longest, String current) {
        this.lastYear = lastYear;
        this.longest = longest;
        this.current = current;
    }

    public String getLastYear() {
        return lastYear;
    }

    public void setLastYear(String lastYear) {
        this.lastYear = lastYear;
    }

    public String getLongest() {
        return longest;
    }

    public void setLongest(String longest) {
        this.longest = longest;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
