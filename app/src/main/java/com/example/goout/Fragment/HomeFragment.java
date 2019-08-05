package com.example.goout.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.goout.PostActivity;
import com.example.goout.R;

public class HomeFragment extends Fragment {

    ImageView img;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        img = view.findViewById(R.id.addimage);

       //img = getView().findViewById(R.id.addimage);


        /*img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.addimage){

                    Intent intent = new Intent(getActivity(), PostActivity.class);
                    getActivity().startActivity(intent);
                }



            }
        });*/




        //img = getView().findViewById(R.id.addimage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PostActivity.class);
                getActivity().startActivity(intent);
            }
        });




        return view;




    }

    public void Click(){

        Intent intent = new Intent(getActivity(), PostActivity.class);
                getActivity().startActivity(intent);
    }



}
