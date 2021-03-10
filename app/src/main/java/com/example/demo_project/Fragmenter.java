package com.example.demo_project;

import androidx.fragment.app.Fragment;

public class Fragmenter {

    private int imageView;
    private String text;

    public Fragmenter(){
    }

    public Fragmenter(int imageView, String text) {
        this.imageView = imageView;
        this.text = text;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
