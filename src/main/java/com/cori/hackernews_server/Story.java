package com.cori.hackernews_server;

public class Story {
    private Long id;
    private String title;
    private String url;
    private String author;
    private Integer score;
    private Integer commentCount;
    private Long publishedAt;  // unix timestamp
    private String type;
    
    // Default constructor
    public Story() {}
    
    // Constructor to convert from HackerNewsItem
    public Story(HackerNewsItem item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.url = item.getUrl();
        this.author = item.getBy();
        this.score = item.getScore();
        this.commentCount = item.getDescendants();
        this.type = item.getType();
        this.publishedAt = item.getTime();
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    
    public Integer getCommentCount() { return commentCount; }
    public void setCommentCount(Integer commentCount) { this.commentCount = commentCount; }
    
    public Long getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Long publishedAt) { this.publishedAt = publishedAt; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}