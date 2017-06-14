package kiitapp.com.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicDemo extends AppCompatActivity
{
    Button b1, b2;
    static  MediaPlayer p;
    TextView td,td2;
    SeekBar sb1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_demo);
        b1 =(Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        td = (TextView)findViewById(R.id.textView1);
        td2 =(TextView)findViewById(R.id.textView2);
        sb1 = (SeekBar)findViewById(R.id.seekBar1);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(fromUser==true)
                {
                    if(p.isPlaying()==true)
                    {
                        p.seekTo(progress);
                    }
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





        if(p==null) {
            p = MediaPlayer.create(this,R.raw.conqueror);
        }

        String totalDuration = "DURATION -"+dispTime(p.getDuration());
        td.setText(totalDuration);




        class RunStatus extends  Thread
        {
            public void run()
            {
                while(p.getCurrentPosition()!=p.getDuration())
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String cp = "Status -"+dispTime(p.getCurrentPosition());
                            td2.setText(cp);
                        }
                    });
                }
            }
        }
        RunStatus t = new RunStatus();
        t.start();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.start();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.pause();
            }
        });


    }

    //milli seond time de rae, ye hmein displayable time dega
    String dispTime(int tims)
    {
        int sec = tims/1000;
        int min = sec/60;
        sec = sec%60;
        String op = String.format("%02d : %02d",min,sec);
        return op;

    }
}
