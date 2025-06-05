package com.cori.hackernews_server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HackerNewsItem {
    private Long id;
    private String type;
    private String by;      // author username
    private Long time;      // unix timestamp
    private String text;    // comment text or story text
    private String url;     // story URL
    private String title;   // story title
    private Integer score;  // story score
    private Integer descendants; // comment count
    private Long[] kids;    // array of comment IDs
    private Boolean deleted;
    private Boolean dead;
    
    // Default constructor
    public HackerNewsItem() {}
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getBy() { return by; }
    public void setBy(String by) { this.by = by; }
    
    public Long getTime() { return time; }
    public void setTime(Long time) { this.time = time; }
    
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    
    public Integer getDescendants() { return descendants; }
    public void setDescendants(Integer descendants) { this.descendants = descendants; }
    
    public Long[] getKids() { return kids; }
    public void setKids(Long[] kids) { this.kids = kids; }
    
    public Boolean getDeleted() { return deleted; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
    
    public Boolean getDead() { return dead; }
    public void setDead(Boolean dead) { this.dead = dead; }

    @Override
    public String toString() {
        return "HackerNewsItem{\n" +
                "  id=" + id + ",\n" +
                "  type='" + type + "',\n" +
                "  by='" + by + "',\n" +
                "  time=" + time + ",\n" +
                "  text='" + (text != null && text.length() > 50 ? text.substring(0, 50) + "..." : text) + "',\n" +
                "  url='" + url + "',\n" +
                "  title='" + title + "',\n" +
                "  score=" + score + ",\n" +
                "  descendants=" + descendants + ",\n" +
                "  kids=" + (kids != null ? java.util.Arrays.toString(kids) : null) + ",\n" +
                "  deleted=" + deleted + ",\n" +
                "  dead=" + dead + "\n" +
                '}';
    }
}
