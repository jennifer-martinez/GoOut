package com.example.goout;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.goout.Adapter.RestauranteAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantesActivity extends AppCompatActivity {

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String, String>>();
    ScriptGroup.Binding bind;
    Adapter adapter;

    private RecyclerView recyclerView;
    private RestauranteAdapter restauranteAdapter;



    String url ="https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJrTLr-GyuEmsRBfy61i59si0&key=AIzaSyCKvCPavYDhPyDcXHULrSoc6V0n4SjOPpw";

    //String url ="https://maps.googleapis.com/maps/api/place/details/json?key=AIzaSyCKvCPavYDhPyDcXHULrSoc6V0n4SjOPpw&placeid=";

    //String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?key=AIzaSyCKvCPavYDhPyDcXHULrSoc6V0n4SjOPpw&query=Restaurantes";

    //poltek+kediri&key=AIzaSyCKvCPavYDhPyDcXHULrSoc6V0n4SjOPpw

    //String urlQuery = "restaurantes";

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_restaurantes, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return view;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        //View view = (R.layout.activity_restaurantes);

        //recyclerView = view.findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, jsonArraytListener, errorListener);
        Volley.newRequestQueue(RestaurantesActivity.this).add(jsonObjectRequest);

    }

    Response.Listener<JSONObject> jsonArraytListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                String nombre= "", ubicacion="", horario ="", telefono="";
                arrayList.clear();
                JSONArray places = response.getJSONArray("results");
                for(int i=0; i<places.length(); i++){
                    JSONObject info = places.getJSONObject(i);
                    nombre = info.getString("name");
                    ubicacion = info.getString("formated_address");
                    horario = info.getString("opening_hours");
                    telefono = info.getString("formatted_phone_number");

                    HashMap<String,String> hashMap = new HashMap<String, String>();
                    hashMap.put("name", nombre);
                    hashMap.put("formated_address", ubicacion);
                    hashMap.put("opening_hours", horario);
                    hashMap.put("formatted_phone_number", telefono);
                    arrayList.add(hashMap);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getBaseContext(), "error", Toast.LENGTH_LONG).show();;
        }
    };
}
