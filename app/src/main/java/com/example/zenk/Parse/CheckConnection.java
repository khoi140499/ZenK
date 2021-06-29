package com.example.zenk.Parse;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.zenk.R;
import com.parse.Parse;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class CheckConnection {
    public CheckConnection() {
    }

    public void QueryConnection(Context context, Class context1, Class activity1, Class activity2,
                                LinearLayout ln){
        ParseQuery<ParseUser> query=ParseUser.getQuery();
        query.findInBackground((objects, e) -> {
            if(e==null){
                if(ParseUser.getCurrentUser()==null) {
                    setAnimation(context, activity2, ln);
                }
                else if(ParseUser.getCurrentUser()!=null){
                    setAnimation(context, context1, ln);
                }
            }
            else{
                setAnimation(context, activity1, ln);
            }
        });
    }

    private void setAnimation(Context context, Class context1, LinearLayout ln){
        Animation ani= AnimationUtils.loadAnimation(context.getApplicationContext(),
                R.anim.animation);
        ani.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent a=new Intent(context, context1);
                context.startActivity(a);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        ln.startAnimation(ani);
    }
}
