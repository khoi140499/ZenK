package com.example.zenk.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zenk.Activity.ForgotPassword;
import com.example.zenk.Activity.Home;
import com.example.zenk.Activity.RegisterActivity;
import com.example.zenk.R;
import com.example.zenk.databinding.ActivityLoginBinding;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private ProgressDialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog=new ProgressDialog(this);
        checkInputLogin();
        Login();
        Register();
        forgotPassword();
    }

    //check space on username
    private void checkInputLogin(){
        binding.username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String[] arr=binding.username.getText().toString().split(" ");
                if(arr.length>1){
                    binding.username.setError("Not space on username");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //check login
    private void Login(){
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.username.getText().toString().isEmpty()){
                    binding.username.setError("");
                }
                else if(binding.password.getText().toString().isEmpty()){
                    binding.password.setError("");
                }
                else{
                    dialog.setMessage("Loading...");
                    dialog.show();
                    ParseUser user=new ParseUser();
                    user.logInInBackground(binding.username.getText().toString(),
                            binding.password.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if(user!=null){
                                dialog.dismiss();
                                Intent a=new Intent(LoginActivity.this, Home.class);
                                startActivity(a);
                            }
                            else{
                                dialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Log in fail. Try again!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    //sign up
    private void Register(){
        binding.sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(a, 90);
            }
        });
    }

    //forgot password
    private void forgotPassword(){
        binding.btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(a);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if(requestCode == 90 && resultCode==RESULT_OK && data!=null){
            Handler handler=new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    binding.username.setText(data.getStringExtra("username"));
                    binding.password.setText(data.getStringExtra("password"));
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}