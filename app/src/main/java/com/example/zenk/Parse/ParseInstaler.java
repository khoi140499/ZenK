package com.example.zenk.Parse;

import android.content.Context;

import com.example.zenk.R;
import com.parse.Parse;

public class ParseInstaler {
    private Context context;
    public ParseInstaler(Context context) {
        this.context=context;
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId(context.getString(R.string.Parse_Application_ID))
                .clientKey(context.getString(R.string.Parse_Client))
                .server(context.getString(R.string.Parse_Server))
                .build());
    }
}
