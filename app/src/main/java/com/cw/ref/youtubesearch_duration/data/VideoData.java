package com.cw.ref.youtubesearch_duration.data;

import com.cw.ref.youtubesearch_duration.utils.TimeAgo;
import com.cw.ref.youtubesearch_duration.utils.YouTubeTimeConvert;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sodha on 8/3/16.
 */
public class VideoData implements Serializable {
    private String kind;
    private String id;
    private String videoTitle;
    private String channelTitle;
    private String videoId;
    private String channelId;
    private String description;
    private String smallThumbnail;
    private String mediumThumbnail;
    private String largeThumbnail;
    private String duration;
    private String viewCount;
    private String likeCount;
    private String dislikeCount;
    private String favouriteCount;
    private String commentCount;
    private String publishedAt;

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    private String timeAgo;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {

        try {
            DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser();
            DateTime dt = parser.parseDateTime(publishedAt);

            long videoSecs = (dt.getMillis())/1000;
            long nowSecs = (new Date().getTime())/1000;
            long secs = nowSecs - videoSecs;
            setTimeAgo(TimeAgo.getTimeAgo(secs));
        } catch (Exception e) {
            e.printStackTrace();
            setTimeAgo("NA");
        } finally {
            this.publishedAt = publishedAt;
        }
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getMediumThumbnail() {
        return mediumThumbnail;
    }

    public void setMediumThumbnail(String mediumThumbnail) {
        this.mediumThumbnail = mediumThumbnail;
    }

    public String getLargeThumbnail() {
        return largeThumbnail;
    }

    public void setLargeThumbnail(String largeThumbnail) {
        this.largeThumbnail = largeThumbnail;
    }

    public String getDuration() {
        return YouTubeTimeConvert.convertYouTubeDuration(duration);
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getViewCount() {
        if(Integer.parseInt(viewCount) > 1000) {
            return viewCount.substring(0, viewCount.length() - 3) + "k";
        }
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(String dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(String favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }
}
