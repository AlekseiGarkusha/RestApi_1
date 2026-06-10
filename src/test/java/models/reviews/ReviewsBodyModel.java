package models.reviews;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReviewsBodyModel(String count, String next, String previous,String results) { }
