package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;

    public CurrentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentFragment newInstance(String param1, String param2) {
        CurrentFragment fragment = new CurrentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View rootView= inflater.inflate(R.layout.fragment_current, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create a list of items (replace with your data source)
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));
        itemList.add(new Item("hello","this is app",R.drawable.adminpass));




        // Create and set the adapter
        //adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(new MyAdapter(getActivity(),itemList));

        return rootView;
    }

}