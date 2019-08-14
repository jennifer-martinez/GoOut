package com.example.goout.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.goout.BaresActivity;
import com.example.goout.CafesActivity;
import com.example.goout.R;
import com.example.goout.RestaurantesActivity;


public class GouOutFragment extends Fragment {


    ImageView restaurantes;
    ImageView cafes;
    ImageView bares;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gou_out, container, false);

        restaurantes = view.findViewById(R.id.restaurantes);
        cafes = view.findViewById(R.id.cafes);
        bares = view.findViewById(R.id.bares);

        restaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestaurantesActivity rest = new RestaurantesActivity();
                rest.setArguments(savedInstanceState);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,rest )
                        .addToBackStack(null)
                        .commit();

            }
        });

        cafes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CafesActivity cafe = new CafesActivity();
                cafe.setArguments(savedInstanceState);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,cafe )
                        .addToBackStack(null)
                        .commit();
            }
        });

        bares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaresActivity bar = new BaresActivity();
                bar.setArguments(savedInstanceState);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,bar )
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;

    }


}
