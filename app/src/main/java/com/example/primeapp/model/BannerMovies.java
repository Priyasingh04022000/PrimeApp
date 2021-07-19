package com.example.primeapp.model;

public class BannerMovies {

    Integer image;
    String movieName;
    String fileUrl;
   //String imageUrl;
   //String fileUrl;

    public BannerMovies(Integer image, String movieName,String fileUrl) {//, String imageUrl, String fileUrl) {
        this.image = image;
        this.movieName = movieName;
       // this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

//    public Integer getId() {
//        return image;
//    }
//
//    public void setId(Integer id) {
//        this.image = image;
//    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }



//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getFileUrl() {
//        return fileUrl;
//    }
//
//    public void setFileUrl(String fileUrl) {
//        this.fileUrl = fileUrl;
//    }
}
