package tv.anandhkumar.examtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView done,timer;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);
        done = findViewById(R.id.done);

        mediaPlayer = MediaPlayer.create(this,R.raw.fv);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("Time : "+String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                done.setText("Done.!");
                mediaPlayer.start();
            }
        }.start();
    }
}
