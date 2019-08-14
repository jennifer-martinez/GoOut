package com.example.goout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.goout.Model.Bar;
import com.example.goout.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.ViewHolder>  {


    private Context mContext;
    private List<Bar> mBar;



    private FirebaseDatabase firebaseDatabase;

    public BarAdapter(Context mContext, List<Bar> mBar) {
        this.mContext = mContext;
        this.mBar = mBar;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bares_item, viewGroup, false);

        return new BarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Bar bar = mBar.get(i);

        viewHolder.nombre.setText(bar.getNombre());
        viewHolder.ubicacion.setText(bar.getUbicacion());
        viewHolder.horarios.setText(bar.getHorarios());
        viewHolder.telefonos.setText(bar.getTelefonos());
        viewHolder.info.setText(bar.getInfo());

        Glide.with(mContext).load(bar.getImagen()).into(viewHolder.imagen);
        //Glide.with(mContext).load(rest.getImagen()).into(viewHolder.imagen);


        /*if(rest.getImagen() == (null)){

            Glide.with(mContext).load("https://firebasestorage.googleapis.com/v0/b/goout-c66fc.appspot.com/o/usuario.png?alt=media&token=f1631c2c-7298-43f3-b082-68ad7f447b50").into(viewHolder.imagen);
        }else{
            Glide.with(mContext).load(rest.getImagen()).into(viewHolder.imagen);
        }
*/

    }

    @Override
    public int getItemCount() {
        return mBar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView ubicacion;
        public TextView horarios;
        public TextView telefonos;
        public ImageView imagen;
        public TextView info;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
            ubicacion = itemView.findViewById(R.id.ubicacion);
            horarios = itemView.findViewById(R.id.horarios);
            telefonos = itemView.findViewById(R.id.telefonos);
            imagen = itemView.findViewById(R.id.imagen);
            info = itemView.findViewById(R.id.info);

        }
    }




}
