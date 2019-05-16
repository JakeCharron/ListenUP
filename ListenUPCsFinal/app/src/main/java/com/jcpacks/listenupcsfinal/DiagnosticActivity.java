package com.jcpacks.listenupcsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DiagnosticActivity extends AppCompatActivity {

    Intent intent;
    String ActualAge;
    String HearingAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic);

        intent = getIntent();
        ActualAge = intent.getStringExtra("ActualAge");
        HearingAge = intent.getStringExtra("HearingAge");

        Log.d("Age Value: ", ActualAge);
        Log.d("Hearing Age: ", HearingAge);

        setContentView(R.layout.activity_diagnostic);

        TextView heatingAgeLabel = findViewById(R.id.hearingAge);
        heatingAgeLabel.setText("Hearing Age: " + HearingAge);

        TextView AgeDif = findViewById(R.id.AgeDifference);
//        try{
//            int actAge = Integer.parseInt(ActualAge);
//            int HeaAge = Integer.parseInt(HearingAge);
//            int difference = actAge-HeaAge;
//            if(difference==0){
//                AgeDif.setText("Your hearing age is the same as your actual age!");
//            }else{
//            }
//        }catch(NumberFormatException e){
//
//        }




    }




}
