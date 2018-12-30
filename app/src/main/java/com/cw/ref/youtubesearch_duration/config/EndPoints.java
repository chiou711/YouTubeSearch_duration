package com.cw.ref.youtubesearch_duration.config;

/**
 * Created by sodha on 10/3/16.
 */
public class EndPoints {
//    public static final String POPULARVIDEO_URL = "https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&regionCode=TW&maxResults=15&key=" + Config.API_KEY;
    public static final String POPULARVIDEO_URL = "https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&regionCode=TW&maxResults=15&key=" + Config.API_KEY;
    public static final String SEARCH_VIDEO_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=15&key=" + Config.API_KEY;
    public static final String VIDEO_DETAILS_URL = "https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&key=" + Config.API_KEY;
    public static final String YOUTUBE_URL_VIDEO = "http://www.youtube.com/watch?v=";
}
