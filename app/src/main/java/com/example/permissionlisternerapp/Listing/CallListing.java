package com.example.permissionlisternerapp.Listing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.permissionlisternerapp.ApplicationJ;
import com.example.permissionlisternerapp.R;

import org.w3c.dom.Text;

public class CallListing extends AppCompatActivity {

    private RecyclerView rvCallData;
    private TextView txtNoData;
    private CallListingAdapter callListingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_listing);

        rvCallData = (RecyclerView) findViewById(R.id.rvCallData);
        txtNoData = (TextView) findViewById(R.id.txtNoData);

        rvCallData.setLayoutManager(new LinearLayoutManager(CallListing.this));

        if(ApplicationJ.db.callListDao().getCallList().size()>0 && ApplicationJ.db.callListDao().getCallList()!=null) {
            Log.e("*+*+*db","Size for the db is : "+ApplicationJ.db.callListDao().getCallList().size());
            rvCallData.setVisibility(View.VISIBLE);
            txtNoData.setVisibility(View.GONE);
            for (int i = 0; i < ApplicationJ.db.callListDao().getCallList().size(); i++) {
                Log.e("*+*+*db","Data id : "+ApplicationJ.db.callListDao().getCallList().get(i).getUniqueId()+" :: state : "+ApplicationJ.db.callListDao().getCallList().get(i).getState()+" :: number : "+ApplicationJ.db.callListDao().getCallList().get(i).getNumber()+" :: start : "+ApplicationJ.db.callListDao().getCallList().get(i).getStartTime()+" :: end :"+ApplicationJ.db.callListDao().getCallList().get(i).getEndTime());
            }

            callListingAdapter = new CallListingAdapter(ApplicationJ.db.callListDao().getCallList(), this);
            rvCallData.setAdapter(callListingAdapter);
        } else {
            Log.e("*+*+*db","Oops no data found");
            rvCallData.setVisibility(View.GONE);
            txtNoData.setVisibility(View.VISIBLE);
        }

    }
}
