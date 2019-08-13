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
import com.example.goout.Model.Restaurants;
import com.example.goout.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder>  {


    private Context mContext;
    private List<Restaurants> mRestaurante;



    private FirebaseDatabase firebaseDatabase;

    public RestauranteAdapter(Context mContext, List<Restaurants> mRestaurante) {
        this.mContext = mContext;
        this.mRestaurante = mRestaurante;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.restaurantes_item, viewGroup, false);

        return new RestauranteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Restaurants rest = mRestaurante.get(i);

        viewHolder.nombre.setText(rest.getNombre());
        viewHolder.ubicacion.setText(rest.getUbicacion());
        viewHolder.horarios.setText(rest.getHorarios());
        viewHolder.telefonos.setText(rest.getTelefonos().toString());
        //viewHolder.imagen.setImageURI(rest.getImagen());

        Glide.with(mContext).load(rest.getImagen()).into(viewHolder.imagen);

        //Glide.with(getContext()).load(Restaurants.getImage()).into(imagen);





        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();

                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
                editor.putString("Nombre", rest.getNombre());
                editor.apply();

                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RestaurantesActivity()).commit();
            }

        });*/

    }

    @Override
    public int getItemCount() {
        return mRestaurante.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView ubicacion;
        public TextView horarios;
        public TextView telefonos;
        public ImageView imagen;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
            ubicacion = itemView.findViewById(R.id.ubicacion);
            horarios = itemView.findViewById(R.id.horarios);
            telefonos = itemView.findViewById(R.id.telefonos);
            imagen = itemView.findViewById(R.id.imagen);

        }
    }




}
