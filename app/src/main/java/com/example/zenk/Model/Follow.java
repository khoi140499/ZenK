package com.example.zenk.Model;

import com.parse.ParseUser;

public class Follow {
    private ParseUser userFollow;
    private ParseUser userFollowing;

    public Follow(ParseUser userFollow, ParseUser userFollowing) {
        this.userFollow = userFollow;
        this.userFollowing = userFollowing;
    }

    public ParseUser getUserFollow() {
        return userFollow;
    }

    public ParseUser getUserFollowing() {
        return userFollowing;
    }
}
