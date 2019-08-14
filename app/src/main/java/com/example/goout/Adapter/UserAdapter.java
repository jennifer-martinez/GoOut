package com.example.goout.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterFactory;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.goout.Fragment.ProfileFragment;
import com.example.goout.Model.User;
import com.example.goout.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUsers;

    private FirebaseUser firebaseUser;

    public UserAdapter(Context mContext, List<User> mUsers) {
        this.mContext = mContext;
        this.mUsers = mUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.user_item, viewGroup, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        final  User user = mUsers.get(i);

       viewHolder.btn_follow.setVisibility(View.VISIBLE);

       viewHolder.username.setText(user.getUsername());
       viewHolder.fullname.setText(user.getFullname());
       if(user.getImageurl()== null){

           Glide.with(mContext).load("https://firebasestorage.googleapis.com/v0/b/goout-c66fc.appspot.com/o/usuario.png?alt=media&token=f1631c2c-7298-43f3-b082-68ad7f447b50").into(viewHolder.image_profile);
       }else{
           Glide.with(mContext).load(user.getImageurl()).into(viewHolder.image_profile);
       }

        isFollowing(user.getId(), viewHolder.btn_follow);

        if(user.getId().equals(firebaseUser.getUid())){
            viewHolder.btn_follow.setVisibility(View.GONE);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
                editor.putString("profileid", user.getId());
                editor.apply();

                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
            }

        });

        viewHolder.btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewHolder.btn_follow.getText().toString().equals("Seguir")){

                    FirebaseDatabase.getInstance().getReference().child("Seguir").child(firebaseUser.getUid()).child("Siguiendo").child(user.getId()).setValue(true);
                    FirebaseDatabase.getInstance().getReference().child("Seguir").child(user.getId()).child("Seguidores").child(firebaseUser.getUid()).setValue(true);
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Seguir").child(firebaseUser.getUid()).child("Siguiendo").child(user.getId()).removeValue();
                    FirebaseDatabase.getInstance().getReference().child("Seguir").child(user.getId()).child("Seguidores").child(firebaseUser.getUid()).removeValue();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;
        public TextView fullname;
        public CircleImageView image_profile;
        public Button btn_follow;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            username = itemView.findViewById(R.id.username);
            fullname = itemView.findViewById(R.id.fullname);
            image_profile = itemView.findViewById(R.id.image_profile);
            btn_follow = itemView.findViewById(R.id.btn_follow);
        }
    }

    private void isFollowing(final String userid, final Button button){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().
                child("Seguir").child(firebaseUser.getUid()).child("Siguiendo");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if( dataSnapshot.child(userid).exists()){
                    button.setText("Siguiendo");
                }else{
                    button.setText("Seguir");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
