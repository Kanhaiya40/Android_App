package com.example.recycler_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SportsData[] sportsData = new SportsData[]{
                new SportsData("Cricket", "England", R.drawable.cricket),
                new SportsData("Football", "England", R.drawable.football),
                new SportsData("Tennis", "America", R.drawable.tennis),
                new SportsData("Athelete", "America", R.drawable.athelete),
                new SportsData("Vollyball", "Holland", R.drawable.vollyball),
                new SportsData("Kabbadi", "India", R.drawable.kabbadi),
                new SportsData("KhoKho", "India", R.drawable.khokho),

        };
        recyclerView.setAdapter(new ProgrammingAdapter(sportsData, MainActivity.this));
    }
}