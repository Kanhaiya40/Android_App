package com.example.demo_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    private ImageView imageView;

    private RecyclerView recyclerView;

    List<Fragmenter> itemData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        @SuppressLint("ResourceType") View view=inflater.inflate(R.layout.home,container,false);

        imageView = view.findViewById(R.id.image);

        Picasso.get().load(getArguments().getString("source")).into(imageView);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new ItemAdapter(initData()));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),MainActivity.class);
                intent.putExtra("url",getArguments().getString("source"));
                startActivity(intent);
            }
        });

        return view;
    }

    private List<Fragmenter> initData() {
        itemData=new ArrayList<>();
        itemData.add(new Fragmenter(R.drawable.players,"cricket"));
        itemData.add(new Fragmenter(R.drawable.players,"cricket"));
        itemData.add(new Fragmenter(R.drawable.players,"cricket"));
        itemData.add(new Fragmenter(R.drawable.players,"cricket"));
        itemData.add(new Fragmenter(R.drawable.players,"cricket"));
        itemData.add(new Fragmenter(R.drawable.players,"cricket"));

        return itemData;
    }
}