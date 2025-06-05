package com.cori.hackernews_server;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@Service
public class HackerNewsService {
    
    private static final Logger logger = Logger.getLogger(HackerNewsService.class.getName());
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String HN_BASE_URL = "https://hacker-news.firebaseio.com/v0";
    
    public List<Long> getTopStoryIds() {
        try {
            String url = HN_BASE_URL + "/topstories.json";
            Long[] storyIds = restTemplate.getForObject(url, Long[].class);
            return Arrays.asList(storyIds != null ? storyIds : new Long[0]);
        } catch (RestClientException e) {
            logger.warning("Failed to fetch top story IDs: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    
    public HackerNewsItem getItem(Long id) {
        try {
            String url = HN_BASE_URL + "/item/" + id + ".json";
            return restTemplate.getForObject(url, HackerNewsItem.class);
        } catch (RestClientException e) {
            logger.warning("Failed to fetch item " + id + ": " + e.getMessage());
            return null;
        }
    }
    
    public List<Story> getTopStories(int limit) {
        try {
            List<Long> storyIds = getTopStoryIds();
            
            if (storyIds.isEmpty()) {
                logger.warning("No story IDs available");
                return Collections.emptyList();
            }
            
            return storyIds.stream()
                    .limit(limit)
                    .map(this::getItem)
                    .filter(item -> item != null && "story".equals(item.getType()))
                    .map(Story::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.severe("Error fetching top stories: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}