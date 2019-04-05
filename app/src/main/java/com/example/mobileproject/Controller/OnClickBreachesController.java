package com.example.mobileproject.Controller;

import android.widget.TextView;

import com.example.mobileproject.View.OnClickBreachesActivity;
import com.example.mobileproject.R;

public class OnClickBreachesController {

    private OnClickBreachesActivity activity;


    public OnClickBreachesController(OnClickBreachesActivity activity) {
        this.activity = activity;
    }

    public void getIncomingIntent(){

        if(activity.getIntent().hasExtra("Domain") && activity.getIntent().hasExtra("DataClasses")
                && activity.getIntent().hasExtra("isVerified") && activity.getIntent().hasExtra("isSensitive")
                && activity.getIntent().hasExtra("isRetired") && activity.getIntent().hasExtra("isSpamList")
                && activity.getIntent().hasExtra("isFabricated")){

            String Domain = activity.getIntent().getStringExtra("Domain");
            String[] DataClasses = activity.getIntent().getStringArrayExtra("DataClasses");
            boolean isVerified = activity.getIntent().getBooleanExtra("isVerified",true);
            boolean isSensitive = activity.getIntent().getBooleanExtra("isSensitive",true);
            boolean isRetired = activity.getIntent().getBooleanExtra("isRetired",true);
            boolean isSpamList = activity.getIntent().getBooleanExtra("isSpamList",true);
            boolean isFabricated = activity.getIntent().getBooleanExtra("isFabricated",true);

            setText(Domain,DataClasses,isVerified,isSensitive,isRetired,isSpamList,isFabricated);
        }
    }


    private void setText(String Domain, String[] DataClasses,boolean isVerified, boolean isSensitive,boolean isRetired,boolean isSpamList, boolean isFabricated ){

        String strDataClasses = "This kind of data have been leak : \n\n";
        TextView viewDomain = activity.findViewById(R.id.domain);
        viewDomain.setText(Domain);

        for (String s : DataClasses)
        {
            strDataClasses = strDataClasses + s + ";" +"\n";
        }
        strDataClasses = strDataClasses + "\n\nAdditional information:\n"
                + "\n Is Verified : " + isVerified
                + "\n Is Sensitive : " + isSensitive
                + "\n Is Retired : " + isRetired
                + "\n Is Spam List : " + isSpamList
                + "\n Is Fabricated : " + isFabricated;

        TextView viewDataClasses = activity.findViewById(R.id.dataclasses);
        viewDataClasses.setText(strDataClasses);

    }
}
