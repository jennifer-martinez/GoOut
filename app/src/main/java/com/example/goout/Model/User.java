package com.example.goout.Model;

public class User {

    private String id;
    private String username;
    private String fullname;
    private String Imageurl;
    private String bio;


    public User(String id, String username, String fullname, String Imageurl, String bio) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.Imageurl = Imageurl;
        this.bio = bio;
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        this.Imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
