package com.cori.hackernews_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    
    @Autowired
    private HackerNewsService hackerNewsService;
    
    @GetMapping("/top")
    public List<Story> getTopStories(@RequestParam(defaultValue = "10") int limit) {
        return hackerNewsService.getTopStories(limit);
    }
    
    @GetMapping("/test")
    public String test() {
        return "Stories API is working!";
    }
}
