package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LCD1Activity extends AppCompatActivity
{
    //LCD is life cycle demonstration
    // every screen has a life cycle
    //it has different stages, we have functions for different stages



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcd1);
        Toast.makeText(this,"LCD1 ACTIVITY : ON CREATE",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"LCD1 ACTIVITY : ON START",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"LCD1 ACTIVITY : ON Resume",Toast.LENGTH_SHORT).show();
    }

    //we start interaction with the screeen after ON RESUME
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this,"LCD1 ACTIVITY : ON Pause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"LCD1 ACTIVITY : ON STOP",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"LCD1 ACTIVITY : ON Destroy",Toast.LENGTH_SHORT).show();
    }
    public void second(View v)
    {
        Intent i = new Intent(LCD1Activity.this,Lcd2Activity.class);
        startActivity(i);
    }

}
