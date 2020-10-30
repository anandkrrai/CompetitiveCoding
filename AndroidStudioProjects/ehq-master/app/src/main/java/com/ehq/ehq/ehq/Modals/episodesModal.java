package com.ehq.ehq.ehq.Modals;

public class episodesModal {

    public String duration,episodeimgsrc,title,videosrc;


    public episodesModal() {

    }

    public episodesModal(String title, String duration, String episodeimagesrc, String videosrc) {
        this.title = title;
        this.duration = duration;
        this.episodeimgsrc = episodeimagesrc;
        this.videosrc = videosrc;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisodeimagesrc() {
        return episodeimgsrc;
    }

    public String getVideosrc() {
        return videosrc;
    }

    public String getDurartion() {
        return duration;
    }

    public void setDurartion(String durartion) {
        this.duration = durartion;
    }

    public void setEpisodeimagesrc(String episodeimagesrc) {
        this.episodeimgsrc = episodeimagesrc;
    }

    public void setVideosrc(String videosrc) {
        this.videosrc = videosrc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
