package com.example.demo_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class IndexHomeFragment extends Fragment {


    RecyclerView recyclerView_horizontal;
    RecyclerView recyclerView_verticle;
    SportsData[] sportsData;
    ViewPager viewPager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sportsData = new SportsData[]{
                new SportsData("Cricket", "England", R.drawable.cricket),
                new SportsData("Football", "England", R.drawable.football),
                new SportsData("Tennis", "America", R.drawable.tennis),
                new SportsData("Athelete", "America", R.drawable.athelete),
                new SportsData("Vollyball", "Holland", R.drawable.vollyball),
                new SportsData("Kabbadi", "India", R.drawable.kabbadi),
                new SportsData("KhoKho", "India", R.drawable.khokho),
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_home, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        recyclerView_verticle = view.findViewById(R.id.recycler_verticle);
        recyclerView_horizontal = view.findViewById(R.id.recycler_horizontal);
        recyclerView_verticle.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView_horizontal.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_verticle.setAdapter(new VerticleAdapter(sportsData, view.getContext()));
        recyclerView_horizontal.setAdapter(new HorizontalAdapter(sportsData, view.getContext()));
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.athelete);
        images.add(R.drawable.kabbadi);
        images.add(R.drawable.cricket);
        images.add(R.drawable.football);
        images.add(R.drawable.khokho);

        viewPager.setAdapter(new SliderAdapter(images));

        init();


        return view;
    }

    private synchronized void init() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AutoSlider(), 2000, 4000);
    }

    public class AutoSlider extends TimerTask {
        @Override
        public void run() {
            if (getActivity()==null){
                return;
            }
            getActivity().runOnUiThread(() -> {
                if (viewPager.getCurrentItem() == 0) {
                    viewPager.setCurrentItem(1);
                } else if (viewPager.getCurrentItem() == 1) {
                    viewPager.setCurrentItem(2);
                } else {
                    viewPager.setCurrentItem(0);
                }
            });
        }
    }
}