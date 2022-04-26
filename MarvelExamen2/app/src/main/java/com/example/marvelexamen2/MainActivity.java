package com.example.marvelexamen2;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Article> results = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        mirarArticulos();
    }

    private void mirarArticulos(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://run.mocky.io/v3/39fcc41e-9d03-486c-8fb2-235e3e831a1b",
                null,
                response -> {
                    //  Toast.makeText(getApplicationContext(),"Funciona",Toast.LENGTH_SHORT).show();

                    if (!response.optString("totalResults").equals("0")) {
                        Toast.makeText(getApplicationContext(),"Funciona",Toast.LENGTH_SHORT).show();
                        JSONArray jsonArray = response.optJSONArray("articles");
                        results = Arrays.asList(new GsonBuilder().create().fromJson(jsonArray.toString(), Article[].class));
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    MyAdapter adapter = new MyAdapter(getApplicationContext(),results);
                    recyclerView.setAdapter(adapter);
                },
                error -> Toast.makeText(getApplicationContext(), "Error en el usuario o en la contraseña", Toast.LENGTH_SHORT).show()
        );
        queue.add(jsonObjectRequest);
    }
}
