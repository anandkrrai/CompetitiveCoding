package com.ehq.ehq.ehq.Modals;

public class seasonModal {

    String dor;
    String language;
    String videosrc;
    String title;
    String imgsrc;
    String summary;
    String director;



    public String getDirector() {

        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public seasonModal(String dor, String language, String imgsrc, String summary, String title) {
        this.dor = dor;
        this.language = language;
        this.imgsrc = imgsrc;
        this.summary = summary;
        this.title = title;
    }




    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
    public seasonModal() {
    }


}
