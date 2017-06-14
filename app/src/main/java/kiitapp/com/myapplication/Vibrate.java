package kiitapp.com.myapplication;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vibrate extends AppCompatActivity
{
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vib_ser_name= Context.VIBRATOR_SERVICE;
                //next line se we get vibrator
                Vibrator vib = (Vibrator) getSystemService(vib_ser_name);
                vib.vibrate(1000);
                //permission bhi do in manifest

            }
        });
    }
}
