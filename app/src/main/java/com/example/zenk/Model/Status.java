package com.example.zenk.Model;

import com.parse.ParseFile;
import com.parse.ParseUser;

public class Status {
    private String objectID;
    private ParseUser user;
    private ParseFile img;
    private String text;

    public Status(String objectID, ParseUser user, ParseFile img, String text) {
        this.objectID = objectID;
        this.user = user;
        this.img = img;
        this.text = text;
    }

    public Status(ParseUser user, ParseFile img, String text) {
        this.user = user;
        this.img = img;
        this.text = text;
    }

    public String getObjectID() {
        return objectID;
    }

    public ParseUser getUser() {
        return user;
    }

    public ParseFile getImg() {
        return img;
    }

    public String getText() {
        return text;
    }
}
