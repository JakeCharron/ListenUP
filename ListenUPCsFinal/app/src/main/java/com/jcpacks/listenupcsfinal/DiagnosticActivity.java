package com.jcpacks.listenupcsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DiagnosticActivity extends AppCompatActivity {

    Intent intent;
    String Time;
    String Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic);

        intent = getIntent();
        Age = intent.getStringExtra("Age");
        Time = intent.getStringExtra("Time");
    }



}
