package com.example.zenk.Model;

import com.parse.ParseFile;

public class User {
    private String objectID;
    private String fullName;
    private String phone;
    private String address;
    private String date;
    private ParseFile img;

    public User(String objectID, String fullName, String phone, String address,
                String date, ParseFile img) {
        this.objectID = objectID;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.img = img;
    }

    public String getObjectID() {
        return objectID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public ParseFile getImg() {
        return img;
    }
}
