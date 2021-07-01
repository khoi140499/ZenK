package com.example.zenk.Model;

import com.parse.ParseFile;
import com.parse.ParseUser;

public class ImagePost {
    private ParseUser userID;
    private ParseFile img;

    public ImagePost(ParseUser userID, ParseFile img) {
        this.userID = userID;
        this.img = img;
    }

    public ParseUser getUserID() {
        return userID;
    }

    public ParseFile getImg() {
        return img;
    }
}
