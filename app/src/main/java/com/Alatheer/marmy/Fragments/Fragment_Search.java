package com.Alatheer.marmy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.Alatheer.marmy.R;

/**
 * Created by elashry on 3/17/2018.
 */

public class Fragment_Search extends Fragment {
EditText search;
RecyclerView recyclerView;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_search,container,false);


        initView();

        return view;
    }

    private void initView() {
        search=view.findViewById(R.id.search);
        recyclerView=view.findViewById(R.id.RecycleSearch);
    }
}
