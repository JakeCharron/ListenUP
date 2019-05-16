package com.jcpacks.listenupcsfinal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {

    Button AudioTestButton;
    Boolean started = false;
    Stopwatch stopwatch = new Stopwatch();
    EditText Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        AudioTestButton = (Button)findViewById(R.id.AudioTestButton);
    }


    public void TestAction(View view){

        if(started == false){
            started = true;
            AudioTestButton.setText("Stop");
            stopwatch.start();
            MediaPlayer mediaPlayer= MediaPlayer.create(this, R.raw.sounds);
            mediaPlayer.start();
        }else{
            stopwatch.stop();
            Age = (EditText)findViewById(R.id.AgeInput);
            Intent intent = new Intent(this, DiagnosticActivity.class);
            intent.putExtra("Time", stopwatch.getElapsedTimeSecs());
            intent.putExtra("Age", Age.getText().toString() );
            startActivity(intent);
        }

    }
}
