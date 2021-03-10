package com.example.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    public FirstFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container,@Nullable Bundle savedInstances){
        return layoutInflater.inflate(R.layout.fragment_first,container,false);
    }
        }