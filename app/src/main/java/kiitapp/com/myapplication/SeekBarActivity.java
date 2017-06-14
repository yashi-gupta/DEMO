package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity

{
    SeekBar s1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        tv1= (TextView)findViewById(R.id.textView1);
        s1 = (SeekBar)findViewById(R.id.seekBar1);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) //used when we need to enter range from user
            {
                tv1.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                Toast.makeText(SeekBarActivity.this,"Start",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Toast.makeText(SeekBarActivity.this,"Stop",Toast.LENGTH_LONG).show();

            }
        });
    }
}
