package com.example.zenk.Model;

import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.ArrayList;

public class Post {
    private String objectID;
    private ParseUser user;
    private String tittle;
    private ArrayList<ParseFile> img;
    private String date;

    public Post(String objectID, ParseUser user, String tittle, ArrayList<ParseFile> img, String date) {
        this.objectID = objectID;
        this.user = user;
        this.tittle = tittle;
        this.img = img;
        this.date = date;
    }

    public String getObjectID() {
        return objectID;
    }

    public ParseUser getUser() {
        return user;
    }

    public String getTittle() {
        return tittle;
    }

    public ArrayList<ParseFile> getImg() {
        return img;
    }

    public String getDate() {
        return date;
    }
}
