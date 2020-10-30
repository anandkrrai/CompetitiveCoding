package com.ehq.ehq.ehq.Modals;

public class musicCategoryModal {

    String artistname,imgsrc,songname,songsrc,duration,lyricist,composer,location_credits,editor,sound_recorder,more_info;


    public musicCategoryModal() {
    }

    public musicCategoryModal(String artistname, String imgsrc, String songname, String songsrc) {

        this.artistname = artistname;
        this.imgsrc = imgsrc;
        this.songname = songname;
        this.songsrc = songsrc;
    }


    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongsrc() {
        return songsrc;
    }

    public void setSongsrc(String songsrc) {
        this.songsrc = songsrc;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLocation_credits() {
        return location_credits;
    }

    public void setLocation_credits(String location_credits) {
        this.location_credits = location_credits;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getSound_recorder() {
        return sound_recorder;
    }

    public void setSound_recorder(String sound_recorder) {
        this.sound_recorder = sound_recorder;
    }

    public String getMore_info() {
        return more_info;
    }

    public void setMore_info(String more_info) {
        this.more_info = more_info;
    }
}
