package com.jcpacks.listenupcsfinal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;
import static java.lang.System.err;

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

    MediaPlayer mediaPlayer;

    public void TestAction(View view){

        if(started == false){
            started = true;
            AudioTestButton.setText("Stop");
            stopwatch.start();
            mediaPlayer= MediaPlayer.create(this, R.raw.sounds);
            mediaPlayer.start();
        }else{
            stopwatch.stop();
            mediaPlayer.stop();

            Log.d("result", Long.toString(stopwatch.getElapsedTimeSecs()));
            String seconds = Long.toString(stopwatch.getElapsedTimeSecs());
            int integerSeconds = 0;
            try{
                int realSeconds = Integer.parseInt(seconds);
                Log.d("Real Seconds" ,Integer.toString(realSeconds));
                integerSeconds = realSeconds;
            }catch (NumberFormatException e){
                Log.d("NumberFormatException", "Yeet delete");
            }
            String spegget = Integer.toString(secToHz(integerSeconds));


            Log.d("Herts", spegget );

            Log.d("Hearing Age", Integer.toString(secToAge(integerSeconds)));

            Age = (EditText)findViewById(R.id.AgeInput);
            String value = Age.getText().toString();
            int actualAge = 0;
            try{
                actualAge = Integer.parseInt(value);
                Log.d("Actual Age", Integer.toString(actualAge));

            }catch (NumberFormatException e){
                Log.d("AgeIn", value);
            }
            Intent intent = new Intent(this, DiagnosticActivity.class);
            intent.putExtra("ActualAge", Integer.toString(actualAge));
            intent.putExtra("HearingAge", Integer.toString(secToAge(integerSeconds)));

            startActivity(intent);

        }

    }

    public static int secToHz( int  s){
        if(s <= 4){
            return 500;
        } else if (s <= 8 && s >4){
            return 750;
        }else if (s <= 12 && s >8){
            return 1000;
        }else if (s <= 16 && s >12){
            return 1500;
        }else if (s <= 20 && s >16){
            return 2000;
        }else if (s <= 24 && s >20){
            return 3000;
        }else if (s <= 28 && s >24){
            return 4000;
        }else if (s <= 32 && s >28){
            return 6000;
        }else if (s <= 36 && s >32){
            return 8000;
        }else if (s <= 40 && s >36){
            return 10000;
        }else if (s <= 44 && s >40){
            return 12000;
        }else if (s <= 48 && s >44){
            return 14000;
        }else if (s <= 52 && s >48){
            return 16000;
        }else if (s >52){
            return 18000;
        }else{
            return 0;
        }
    }

    public static int secToAge(int seconds ){

        int hz = secToHz( seconds);

        int a = 0;
        if(hz>4000){
            a = 2;
        }
        if (hz > 4000 && hz <= 10000){
            a = 4;
        }
        if (hz>10000){
            a = 7;
        }
        return(112-(hz/250)-a-((hz/250)/10));
    }





}
