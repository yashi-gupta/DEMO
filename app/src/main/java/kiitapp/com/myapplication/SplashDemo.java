package kiitapp.com.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashDemo extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_demo);


      class  Splash extends Thread
      {
          public void run()
          {
              try
              {
                  Thread.sleep(3000);
                  Intent i = new Intent(SplashDemo.this,MenuActivity.class);
                  startActivity(i);
                  finish();// by this it doesn't appear while exiting the screen
              }
              catch(Exception e)
              {}
          }
      }

        SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(this);
        boolean splashStatus = setting.getBoolean("key2",true);
        if(splashStatus == true)
        {
            Splash s = new Splash();
            s.start();
        }
            else
            {
                Intent i = new Intent(SplashDemo.this,MenuActivity.class);
                startActivity(i);
                finish();
            }
        }



    }
