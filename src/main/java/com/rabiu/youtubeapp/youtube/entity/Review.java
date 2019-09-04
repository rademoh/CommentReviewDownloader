package com.rabiu.youtubeapp.youtube.entity;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @author Rabiu Ademoh
 */
public class Review {

    @CsvBindByPosition(position = 0)
    private String userName;
    @CsvBindByPosition(position = 1)
    private String date;
    @CsvBindByPosition(position = 2)
    private String starRating;
    @CsvBindByPosition(position = 3)
    private String reviews;
    @CsvBindByPosition(position = 4)
    private String link;

    public Review(String userName, String date, String starRating, String reviews, String link) {
        this.userName = userName;
        this.date = date;
        this.starRating = starRating;
        this.reviews = reviews;
        this.link = link;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
