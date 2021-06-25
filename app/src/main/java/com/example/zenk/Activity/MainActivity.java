package com.example.zenk.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zenk.Parse.CheckConnection;
import com.example.zenk.Parse.ParseInstaler;
import com.example.zenk.R;
import com.example.zenk.databinding.ActivityHomeBinding;
import com.example.zenk.databinding.ActivityMainBinding;
import com.example.zenk.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new ParseInstaler(this);
        setAnimationLayout();
    }
    private void setAnimationLayout(){
        new CheckConnection().QueryConnection(MainActivity.this,
                Home.class, ConnectionFail.class, LoginActivity.class, binding.container);
    }
}