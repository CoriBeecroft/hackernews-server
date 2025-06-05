package com.cori.hackernews_server;

import java.util.List;
import java.util.ArrayList;

public class Comment {
    private Long id;
    private String author;
    private Long publishedAt;  // unix timestamp
    private String type;
    private String text;
    private List<Comment> children = new ArrayList<Comment>();
    
    // Default constructor
    public Comment() {}
    
    // Constructor to convert from HackerNewsItem
    public Comment(HackerNewsItem item) {
        this.id = item.getId();
        this.author = item.getBy();
        this.type = item.getType();
        this.publishedAt = item.getTime();
        this.text = item.getText();
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Long getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Long publishedAt) { this.publishedAt = publishedAt; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<Comment> getChildren() { return children; }
    public void setChildren(List<Comment> children) { this.children = children; }

    @Override
    public String toString() {
        return "id: " + this.id + "\n"
            + "author: " + this.author + "\n"
            + "type: " + this.type + "\n"
            + "publishedAt: " + this.publishedAt + "\n"
            + "text: " + this.text + "\n"
            + "children: "  + this.children + "\n"
            ;
    }
}