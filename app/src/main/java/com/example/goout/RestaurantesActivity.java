package com.example.goout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goout.Adapter.RestauranteAdapter;
import com.example.goout.Model.Restaurants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RestaurantesActivity extends Fragment {


    RestauranteAdapter restauranteAdapter;
    RecyclerView recyclerView;
    List<Restaurants> mRestaurants;


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);


        /*recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        mRestaurants = new ArrayList<>();
        restauranteAdapter = new RestauranteAdapter(getBaseContext(),mRestaurants);
        //restauranteAdapter = new RestauranteAdapter(getContext(), restaurantsList);
        recyclerView.setAdapter(restauranteAdapter);

        readUser();


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mRestaurants = new ArrayList<>();
        restauranteAdapter = new RestauranteAdapter(this,mRestaurants);
        //restauranteAdapter = new RestauranteAdapter(getContext(), restaurantsList);
        recyclerView.setAdapter(restauranteAdapter);

        readUser();

    }*/




    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_restaurantes, container, false);



        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRestaurants = new ArrayList<>();
        restauranteAdapter = new RestauranteAdapter(getContext(), mRestaurants);
        //restauranteAdapter = new RestauranteAdapter(getContext(), restaurantsList);
        recyclerView.setAdapter(restauranteAdapter);

        readUser();

        //searchUsers("categorias");

        return view;
    }



    private void searchUsers(String s){

        Query query = FirebaseDatabase.getInstance().getReference("categorias");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mRestaurants.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Restaurants rest = snapshot.getValue(Restaurants.class);
                    mRestaurants.add(rest);
                }
                restauranteAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    private  void readUser(){

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("categorias").child("Restaurantes");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (!reference.toString().equals("")) {
                    mRestaurants.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Restaurants rest = snapshot.getValue(Restaurants.class);
                        mRestaurants.add(rest);
                    }

                    restauranteAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
