package com.cori.hackernews_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    
    @Autowired
    private HackerNewsService hackerNewsService;
    
    @GetMapping("/top")
    public ResponseEntity<?> getTopStories(@RequestParam(defaultValue = "10") int limit) {
        // Validate limit parameter
        if (limit <= 0 || limit > 100) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "Limit must be between 1 and 100"));
        }

        try {
            List<Story> stories = hackerNewsService.getTopStories(limit);
            
            if (stories.isEmpty()) {
                return ResponseEntity.ok()
                    .body(Map.of(
                        "stories", stories,
                        "message", "No stories available at the moment"
                    ));
            }

            return ResponseEntity.ok(stories);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(Map.of("error", "Unable to fetch stories at this time"));
        }
    }
    @GetMapping("/{id}/comments")
    public ResponseEntity<?> getStoryComments(@PathVariable Long id) {
        try {
            List<Comment> comments = hackerNewsService.getCommentsForStory(id);

            if (comments.isEmpty()) {
                return ResponseEntity.ok()
                    .body(Map.of(
                        "comments", comments,
                        "message", "No comments available at the moment"
                    ));
            }

            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(Map.of("error", "Unable to fetch comments at this time"));
        }
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        return ResponseEntity.ok(Map.of("message", "Stories API is working!"));
    }
}