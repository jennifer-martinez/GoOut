package com.example.goout.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goout.Adapter.PostAdapter;
import com.example.goout.Model.Post;
import com.example.goout.PostActivity;
import com.example.goout.R;

import java.util.List;

public class HomeFragment extends Fragment {

    ImageView img;

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private List<String> followingList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);




        img = view.findViewById(R.id.addimage);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PostActivity.class);
                getActivity().startActivity(intent);
            }
        });





        return view;





    }







}
