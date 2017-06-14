package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Lcd2Activity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcd1);
        Toast.makeText(this,"LCD2 ACTIVITY : ON CREATE",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"LCD2 ACTIVITY : ON START",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"LCD2 ACTIVITY : ON Resume",Toast.LENGTH_SHORT).show();
    }

    //we start interaction with the screeen after ON RESUME
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this,"LCD2 ACTIVITY : ON Pause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"LCD2 ACTIVITY : ON STOP",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"LCD2 ACTIVITY : ON Destroy",Toast.LENGTH_SHORT).show();
    }

}
