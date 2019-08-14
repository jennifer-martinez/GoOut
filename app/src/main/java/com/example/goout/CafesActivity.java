package com.example.goout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goout.Adapter.CafeAdapter;
import com.example.goout.Model.Cafe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CafesActivity extends Fragment {


    CafeAdapter cafeAdapter;
    RecyclerView recyclerView;
    List<Cafe> mCafe;







    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_cafes, container, false);



        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mCafe = new ArrayList<>();
        cafeAdapter = new CafeAdapter(getContext(), mCafe);
        //restauranteAdapter = new RestauranteAdapter(getContext(), restaurantsList);
        recyclerView.setAdapter(cafeAdapter);

        readUser();


        return view;
    }







    private  void readUser(){

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("categorias").child("Cafes");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (!reference.toString().equals("")) {
                    mCafe.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Cafe cafe = snapshot.getValue(Cafe.class);
                        mCafe.add(cafe);
                    }

                    cafeAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
