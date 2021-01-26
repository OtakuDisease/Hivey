package com.example.hivey.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hivey.R;

public class GalleryFragment extends Fragment {

    TextView Bees;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        Bees = root.findViewById(R.id.Bees);
        //final TextView humidity = root.findViewById(R.id.humidity);
        //final TextView temperature = root.findViewById(R.id.temperature);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Bees.setText(s);
               // humidity.setText(s);
              //  temperature.setText(s);
            }
        });
        return root;
    }
}