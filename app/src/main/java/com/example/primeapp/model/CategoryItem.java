package com.example.primeapp.model;

public class CategoryItem {
    Integer image;
    String movieName;
    String fileUrl;

    public CategoryItem(Integer image, String movieName,String fileUrl) {
        this.image = image;
        this.movieName = movieName;
        this.fileUrl=fileUrl;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
