package com.rabiu.youtubeapp.youtube.service;

import org.springframework.stereotype.Service;

/**
 * @author Rabiu Ademoh
 */

@Service
public class APIFactory {

    public API getReviews(String url){
        if(url == null){
            return null;
        }
        if(url.contains("youtube")){
            return new YoutubeService();

        } else if(url.contains("amazon")){
            return new AmazonScrappingService();

        }
        return null;
    }
}
