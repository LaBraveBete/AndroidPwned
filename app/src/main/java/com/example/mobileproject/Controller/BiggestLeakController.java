package com.example.mobileproject.Controller;

import android.app.ProgressDialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.example.mobileproject.Model.DataBreachesModel;
import com.example.mobileproject.Network.GetDataService;
import com.example.mobileproject.R;
import com.example.mobileproject.Network.RetrofitClientInstance;
import com.example.mobileproject.View.BiggestLeakActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiggestLeakController {

    private BiggestLeakActivity activity;
    CustomBreachesAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    public BiggestLeakController(BiggestLeakActivity activity) {
        this.activity = activity;
    }

    public void CallAPIAndGenerateView(){

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<DataBreachesModel>> call = service.getAllBreaches();
        call.enqueue(new Callback<List<DataBreachesModel>>() {
            @Override
            public void onResponse(Call<List<DataBreachesModel>> call, Response<List<DataBreachesModel>> response) {
                progressDialog.dismiss();

                Toast.makeText(activity, "on response ok", Toast.LENGTH_SHORT).show();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<DataBreachesModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(activity, t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("message error", t.toString());
            }
        });
    }

    private void generateDataList(List<DataBreachesModel> Breaches) {
        recyclerView = activity.findViewById(R.id.customRecyclerView);
        adapter = new CustomBreachesAdapter(activity,Breaches);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
