package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Ye poore mobile mein broadcast hoga
//this is an e4xample of broadcast as thrown by the system
//by an object of intent
//nitent is broadcast
public class BroadcastDemo extends AppCompatActivity
{
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_demo);
        b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent();
                i.setAction("rcpl.kiit.EXAM_ALERT");
                i.putExtra("INFO","Scheduled after Durga Puja");
                i.putExtra("TYPE","MCQ");
                i.putExtra("MARKS","70");

                sendBroadcast(i);
            }
        });
    }
}


//button click karne pe broadcast hojayega
//but to perform any operation on it we need a receiver
//isko suunne wala koi hona chaiye
//is code ko run karne se koi visible action nahi hoga
//internally broadcast hojayega
//we will need a receiver