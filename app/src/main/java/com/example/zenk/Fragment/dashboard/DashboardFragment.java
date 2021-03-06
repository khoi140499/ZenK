package com.example.zenk.Fragment.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.zenk.databinding.FragmentDashboardBinding;
import com.parse.ParseUser;
import com.squareup.picasso.Picasso;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Picasso.get().load(ParseUser.getCurrentUser().getParseFile("img").getUrl()).into(binding.profileImg);
        binding.profileFullname.setText(ParseUser.getCurrentUser().getString("name"));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}