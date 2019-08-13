package com.example.goout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goout.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RestauranteAdapter extends BaseAdapter {


    ArrayList<HashMap<String,String>> arrayList;
    AppCompatActivity appCompatActivity;
    LayoutInflater layoutInflater;

    public RestauranteAdapter(ArrayList<HashMap<String,String>> arrayList, AppCompatActivity appCompatActivity){

        this.arrayList = arrayList;
        this.appCompatActivity = appCompatActivity;
        layoutInflater = (LayoutInflater)
                this.appCompatActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        v = layoutInflater.inflate(R.layout.restaurantes_item, viewGroup,false);

        HashMap<String, String > hashMap = new HashMap<String, String>();
        hashMap = arrayList.get(i);

        ((TextView)v.findViewById(R.id.nombre)).setText(hashMap.get("nombre"));
        ((TextView)v.findViewById(R.id.ubicacion)).setText(hashMap.get("ubicacion"));
        ((TextView)v.findViewById(R.id.horario)).setText(hashMap.get("horario"));
        ((TextView)v.findViewById(R.id.telefono)).setText(hashMap.get("telefono"));



        return null;
    }
}
