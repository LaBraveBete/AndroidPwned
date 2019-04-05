package com.example.mobileproject.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileproject.Model.DataBreachesModel;
import com.example.mobileproject.R;
import com.example.mobileproject.View.OnClickBreachesActivity;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.lang.String.valueOf;

public class CustomBreachesAdapter extends RecyclerView.Adapter<CustomBreachesAdapter.CustomViewHolder> {

    private List<DataBreachesModel> dataList;
    private Context context;

    public CustomBreachesAdapter(Context context, List<DataBreachesModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        TextView txtDescription;
        TextView txtPwndCount;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title_customview);
            txtDescription = mView.findViewById(R.id.descriptionText);
            txtPwndCount = mView.findViewById(R.id.pwnd_count);
            coverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {

        holder.txtTitle.setText(dataList.get(position).getTitle());//here
        holder.txtDescription.setText(Html.fromHtml(dataList.get(position).getDescription()).toString());
        String account =  "Pwnd Account: " + valueOf(dataList.get(position).getPwnCount());
        holder.txtPwndCount.setText(account);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getLogoPath())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .resize(100,100)
                .into(holder.coverImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OnClickBreachesActivity.class);
                intent.putExtra("Domain",dataList.get(position).getDomain());
                intent.putExtra("DataClasses",dataList.get(position).getDataClasses());
                intent.putExtra("isVerified",dataList.get(position).isVerified());
                intent.putExtra("isSensitive",dataList.get(position).isSensitive());
                intent.putExtra("isRetired",dataList.get(position).isRetired());
                intent.putExtra("isSpamList",dataList.get(position).isSpamList());
                intent.putExtra("isFabricated",dataList.get(position).isFabricated());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

