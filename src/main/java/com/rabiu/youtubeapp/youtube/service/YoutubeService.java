package com.rabiu.youtubeapp.youtube.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.rabiu.youtubeapp.youtube.entity.Review;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rabiu Ademoh
 */

@Service
public class YoutubeService implements API {

    private static final String PATH = "./youtube-reviews.csv";

    public List<Review>  getPageReviews(){

        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("Username","Date","Ratings","Reviews","Link"));
        reviews.add(new Review("rademoh","12/02/2018","3","great videos2","www.youtube.com/2"));
        reviews.add(new Review("rademoh1","12/02/2018","4","great content3","www.youtube.com/1"));
        reviews.add(new Review("rademoh2","12/02/2018","5","great content11","www.youtube.com/5"));
        reviews.add(new Review("rademoh3","12/02/2018","2","great content2","www.youtube.com/3"));
        reviews.add(new Review("rademoh4","12/02/2018","1","great content2","www.youtube.com/1"));

        return  reviews;
    }


    @Override
    public void getPageReviewsAndComments(String URL) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(PATH))

        ) {
            StatefulBeanToCsv<Review> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withOrderedResults(true)
                    .build();

            beanToCsv.write(getPageReviews());
        }

    }
}
