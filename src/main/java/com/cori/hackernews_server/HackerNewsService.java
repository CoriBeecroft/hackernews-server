package com.cori.hackernews_server;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HackerNewsService {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String HN_BASE_URL = "https://hacker-news.firebaseio.com/v0";
    
    public List<Long> getTopStoryIds() {
        String url = HN_BASE_URL + "/topstories.json";
        Long[] storyIds = restTemplate.getForObject(url, Long[].class);
        return Arrays.asList(storyIds != null ? storyIds : new Long[0]);
    }
    
    public HackerNewsItem getItem(Long id) {
        String url = HN_BASE_URL + "/item/" + id + ".json";
        return restTemplate.getForObject(url, HackerNewsItem.class);
    }
    
    public List<Story> getTopStories(int limit) {
        List<Long> storyIds = getTopStoryIds();
        
        return storyIds.stream()
                .limit(limit)
                .map(this::getItem)
                .filter(item -> item != null && "story".equals(item.getType()))
                .map(Story::new)
                .collect(Collectors.toList());
    }
}
