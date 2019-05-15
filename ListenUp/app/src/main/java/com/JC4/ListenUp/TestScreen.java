package com.JC4.ListenUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen);
    }

    /** Called when the user starts the test */
    public void startTest(View view) {
        Log.d("Start Test Clicked", "Started");
//        start noise
//        create timer to global var
//        change button title to end
        Button button = (Button)findViewById(R.id.testControl);
        button.setText("Stop");

    }
    /** Called when the user starts the test */
    public void endTest(View view) {
        Log.d("End Test Clicked", "Ended");
//        stop global timer
//        calculate test results and render it into the textField

    }

}
