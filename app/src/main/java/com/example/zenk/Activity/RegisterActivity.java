package com.example.zenk.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.zenk.R;
import com.example.zenk.databinding.ActivityRegisterBinding;
import com.parse.ParseUser;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog=new ProgressDialog(this);
        checkInput();
        pickDate();
        Register();
    }

    //register
    private void Register(){
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading...");
                dialog.show();
                ParseUser user=new ParseUser();
                user.setEmail(binding.email.getText().toString());
                user.setUsername(binding.username.getText().toString());
                user.setPassword(binding.password.getText().toString());
                user.put("phone", Integer.parseInt(binding.phone.getText().toString()));
                user.put("date", binding.date.getText().toString());
                user.put("address", binding.address.getText().toString());
                user.signUpInBackground(e -> {
                    if(e==null){
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Please check mail before" +
                                " login!", Toast.LENGTH_SHORT).show();
                        ParseUser.logOut();
                        Intent a=new Intent();
                        a.putExtra("username", binding.username.getText().toString());
                        a.putExtra("password", binding.password.getText().toString());
                        setResult(RESULT_OK, a);
                        finish();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,
                                "Register fail! Try again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    //check input
    private void checkInput(){
        binding.username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String[] arr=binding.username.getText().toString().split(" ");
                if(binding.username.getText().toString().length()==0){
                    binding.username.setError("");
                    binding.register.setEnabled(false);
                }
                if(arr.length>1){
                    binding.username.setError("Username have not space");
                    binding.register.setEnabled(false);
                }
                else{
                    binding.register.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.password.getText().toString().length()==0){
                    binding.password.setError("Password is empty");
                    binding.register.setEnabled(false);
                }
                else{
                    binding.register.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String[] arr=binding.phone.getText().toString().split("");
                try {
                    if(binding.phone.getText().toString().length()<10){
                        binding.register.setEnabled(false);
                        binding.phone.setError("length must be 10 and start with 0 or 84");
                    }
                    else{
                        if( arr[0].equals("0")==false || (arr[0]+arr[1]).equals("84")==false){
                            binding.register.setEnabled(false);
                            binding.phone.setError("length must be 10 and start with 0 or 84");
                        }
                        else{
                            binding.register.setEnabled(true);
                        }
                    }
                }catch (NumberFormatException| ArrayIndexOutOfBoundsException e){}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.address.getText().toString().length()==0){
                    binding.register.setEnabled(false);
                    binding.address.setError("");
                }
                else{
                    binding.register.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.name.getText().toString().length()==0){
                    binding.register.setEnabled(false);
                    binding.name.setError("Fullname not a zero");
                }
                else{
                    binding.register.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //pick date birthday
    private void pickDate(){
        binding.date.setOnClickListener(new View.OnClickListener() {
            Calendar cal=Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH);
            int day=cal.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View v) {
                DatePickerDialog a=new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year2, int month2, int dayOfMonth2) {
                        binding.date.setText(year2+"/"+(month2+1)+"/"+dayOfMonth2);
                    }
                }, year, month ,day);
                a.show();
            }
        });
    }
}