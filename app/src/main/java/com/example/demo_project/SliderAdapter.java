package com.example.demo_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    List<Integer> listOfImages;

    public SliderAdapter(List<Integer> listOfImages) {
        this.listOfImages = listOfImages;
    }


    @Override
    public int getCount() {
        return listOfImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.image_view_layout, container, false);
        ImageView imageView = view.findViewById(R.id.imagecorner);
        imageView.setImageResource(listOfImages.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
