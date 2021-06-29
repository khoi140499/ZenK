package com.example.zenk.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zenk.R;
import com.example.zenk.databinding.ActivityForgotPasswordBinding;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ForgotPassword extends AppCompatActivity {
    private ActivityForgotPasswordBinding binding;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog=new ProgressDialog(this);
    }

    private void forgotPassword(){
        binding.forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.email.getText().toString().isEmpty()){
                    binding.email.setError("");
                }
                else{
                    ParseUser.requestPasswordResetInBackground(binding.email.getText().toString(), e -> {
                        if(e==null){
                            Toast.makeText(ForgotPassword.this,
                                    "Success! Please check email!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(ForgotPassword.this,
                                    "Fail! Try again", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}