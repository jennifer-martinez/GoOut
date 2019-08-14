package com.example.goout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goout.Adapter.BarAdapter;
import com.example.goout.Model.Bar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BaresActivity extends Fragment {


    BarAdapter barAdapter;
    RecyclerView recyclerView;
    List<Bar> mBar;







    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_bares, container, false);



        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mBar = new ArrayList<>();
        barAdapter = new BarAdapter(getContext(), mBar);
        //restauranteAdapter = new RestauranteAdapter(getContext(), restaurantsList);
        recyclerView.setAdapter(barAdapter);

        readUser();


        return view;
    }







    private  void readUser(){

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("categorias").child("Bares");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (!reference.toString().equals("")) {
                    mBar.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Bar bar = snapshot.getValue(Bar.class);
                        mBar.add(bar);
                    }

                    barAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
