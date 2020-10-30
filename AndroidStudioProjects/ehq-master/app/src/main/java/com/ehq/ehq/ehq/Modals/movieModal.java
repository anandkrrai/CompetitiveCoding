package com.ehq.ehq.ehq.Modals;

public class movieModal {

    String director , dor,duration,imgsrc,summary,title,videosrc;

    public movieModal() {
    }

    public movieModal(String director, String dor, String duration, String imgsrc, String summary, String title, String videosrc) {
        this.director = director;
        this.dor = dor;
        this.duration = duration;
        this.imgsrc = imgsrc;
        this.summary = summary;
        this.title = title;
        this.videosrc = videosrc;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideosrc() {
        return videosrc;
    }

    public void setVideosrc(String videosrc) {
        this.videosrc = videosrc;
    }
}
