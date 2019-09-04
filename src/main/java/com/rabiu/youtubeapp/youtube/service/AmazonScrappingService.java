package com.rabiu.youtubeapp.youtube.service;

/**
 * @author Rabiu Ademoh
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import com.rabiu.youtubeapp.youtube.utils.CSVUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


@Service
public class AmazonScrappingService implements API {


    private HashSet<String> links;

    public AmazonScrappingService() {
        links = new HashSet<String>();
    }

    @SuppressWarnings("unused")
    public void getPageReviews(String URL) throws IOException {

        String csvFile = "./amazon-reviews.csv";
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, Arrays.asList("Name", "Rating", "Comment", "Date"));

        if (!links.contains(URL)) {
            try {
                // 4. (i) If not add it to the index
                if (links.add(URL)) {

                }
                // 2. Fetch the HTML code
                Document document = Jsoup.connect(URL).userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
                        .timeout(5000).get();
                // 3. Parse the HTML to extract links to other URLs
                Elements reviews = document.select("div.review-views");

                for (Element review : reviews) {
                    Elements d = review.select("div.review");
                    for (Element dd : d) {
                        String data = "";
                        String name = "";
                        String rating = "";
                        String comment = "";
                        String date = "";
                        Element dataElement = dd.select("div span.a-profile-name").first();
                        if(dataElement != null) {
                            data = data+ "Username : "+dataElement.text();
                            name = dataElement.text();
                        }

                        dataElement = dd.select("div i.review-rating").first();
                        if(dataElement != null) {
                            data = data+ ",Rating : "+dataElement.text();
                            rating = dataElement.text();
                        }

                        dataElement = dd.select("div div.reviewText span").first();
                        if(dataElement != null) {
                            data = data+ ",Comment : "+dataElement.text();
                            comment = dataElement.text();
                        }

                        dataElement = dd.select("div span.review-date").first();
                        if(dataElement != null) {
                            data = data+ ",Date : "+dataElement.text();
                            date = dataElement.text();
                        }
                        comment = comment.replaceAll(",", "\\.");

                        System.out.println(data);
                        CSVUtils.writeLine(writer, Arrays.asList(name, rating, comment, date));
                    }

                }

                writer.flush();
                writer.close();


            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }


    @Override
    public void getPageReviewsAndComments(String URL) throws IOException {
        getPageReviews(URL);
    }
}