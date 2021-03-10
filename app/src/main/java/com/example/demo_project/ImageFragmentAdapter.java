package com.example.demo_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ImageFragmentAdapter extends FragmentStatePagerAdapter {
  String[] images=new String[]{
          "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwebmeup.com%2Fblog%2Fstock-images-to-avoid.html&psig=AOvVaw36WP1eepjc75LpoNmSemvI&ust=1615465628821000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIju-Mncpe8CFQAAAAAdAAAAABAI",
          "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F644437027909509488%2F&psig=AOvVaw36WP1eepjc75LpoNmSemvI&ust=1615465628821000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIju-Mncpe8CFQAAAAAdAAAAABAO",
          "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fhorizon&psig=AOvVaw36WP1eepjc75LpoNmSemvI&ust=1615465628821000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIju-Mncpe8CFQAAAAAdAAAAABAT"
  };
    public ImageFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        HomeFragment homeFragment=new HomeFragment();
        Bundle bundle=new Bundle();
        bundle.putString("source",images[position]);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public int getCount() {
        return images.length;
    }
}
