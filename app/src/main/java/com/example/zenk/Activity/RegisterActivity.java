package com.example.zenk.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zenk.R;
import com.example.zenk.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}