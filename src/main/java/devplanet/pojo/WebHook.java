package devplanet.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by jojoldu@gmail.com on 2016-04-22.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHook {
    private String name;
    private Map<String, String> config;
    private String[] events;
    private boolean active;

    public WebHook() {}

    public WebHook(String name, Map<String, String> config, String[] events, boolean active) {
        this.name = name;
        this.config = config;
        this.events = events;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public String[] getEvents() {
        return events;
    }

    public void setEvents(String[] events) {
        this.events = events;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
