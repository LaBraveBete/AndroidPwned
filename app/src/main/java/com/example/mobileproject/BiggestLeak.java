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


    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(BiggestLeak.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();



        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<DataModel>> call = service.getAllBreaches();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                progressDoalog.dismiss();
                //generateDataList(response.body());
               // Log.d("message error",getName().toString());
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(BiggestLeak.this, t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("message error",t.toString());
            }
        });
    }


    private void generateDataList(List<DataModel> breaches) {
        recyclerView = findViewById(R.id.RecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BiggestLeak.this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(adapter);
    }


}



