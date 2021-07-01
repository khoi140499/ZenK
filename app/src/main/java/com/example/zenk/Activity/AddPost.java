package com.example.zenk.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zenk.R;
import com.example.zenk.RecycleViewAdapter.ListGalleryAdapter;
import com.example.zenk.databinding.ActivityAddPostBinding;

import java.util.ArrayList;
import java.util.List;

public class AddPost extends AppCompatActivity {
    private ActivityAddPostBinding binding;
    private ArrayList<String> list1=new ArrayList<>();
    private ListGalleryAdapter adapter;
    private String[] projection = {MediaStore.MediaColumns.DATA};
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addpost, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        if(item.getItemId()==R.id.addpost_next){
            Intent a=new Intent(this, AcceptAddPost.class);
            a.putStringArrayListExtra("img", list1);
            startActivity(a);
        }
        return super.onOptionsItemSelected(item);
    }

    //load image from store
    private void loadImage(){
        Cursor cursor = getContentResolver().query
                (MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection,
                        null, null, null);
        while (cursor.moveToNext()) {
            String absolutePathOfImage = cursor.getString
                    (cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
            list.add(absolutePathOfImage);
            binding.recycleAllimage.setLayoutManager(new StaggeredGridLayoutManager(3,
                    StaggeredGridLayoutManager.VERTICAL));
            binding.recycleAllimage.setHasFixedSize(true);
            adapter=new ListGalleryAdapter(this, list, list1);
            binding.recycleAllimage.setAdapter(adapter);
        }
    }
}