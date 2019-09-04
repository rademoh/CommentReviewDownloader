package com.rabiu.youtubeapp.youtube.service;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

/**
 * @author Rabiu Ademoh
 */
public interface API {

     void getPageReviewsAndComments(String URL) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
}
