package com.example.demo_project;

public class SportsData {

    String text;
    String subText;
    int image;

    public SportsData(String text, String subText, int image) {
        this.text = text;
        this.subText = subText;
        this.image = image;
    }

    public String getText() {
        return text;
    }


    public String getSubText() {
        return subText;
    }


    public int getImage() {
        return image;
    }
}
