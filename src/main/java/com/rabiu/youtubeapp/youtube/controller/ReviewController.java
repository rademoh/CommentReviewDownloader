package com.rabiu.youtubeapp.youtube.controller;

import com.rabiu.youtubeapp.youtube.service.API;
import com.rabiu.youtubeapp.youtube.service.APIFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rabiu Ademoh
 */

@RestController
@RequestMapping(value = "/api/v1/")
public class ReviewController {
    @Autowired
    APIFactory apiFactory;

    @GetMapping("/get-reviews")
    public ResponseEntity<String> exportCsv (@RequestParam("URL") String URL) throws Exception {
        if (!URL.isEmpty()) {
            API api = apiFactory.getReviews(URL);
            api.getPageReviewsAndComments(URL);
        }else{
            return new ResponseEntity<String>("URL can't be empty",HttpStatus.BAD_REQUEST);
        }
       return new  ResponseEntity<String>(HttpStatus.OK);
    }



}
