package com.example.mobileproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiggestLeak extends AppCompatActivity {

    CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biggest_leak);

        progressDialog = new ProgressDialog(BiggestLeak.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();



        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<DataModel>> call = service.getAllBreaches();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                progressDialog.dismiss();



                /*
                List<DataModel> Test =response.body();
                for (DataModel t: Test)
                {

                    Log.d("Test de la mort", t.getName());
                    Log.d("Test de la mort", t.getLogoPath());
                }
                */
                Toast.makeText(BiggestLeak.this, "on response ok", Toast.LENGTH_SHORT).show();
                generateDataList(response.body());


            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(BiggestLeak.this, t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("message error",t.toString());
            }
        });
    }

    private void generateDataList(List<DataModel> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BiggestLeak.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}



