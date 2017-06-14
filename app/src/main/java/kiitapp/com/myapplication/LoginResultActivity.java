package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity  extends AppCompatActivity
{   TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
        tv1 = (TextView) findViewById(R.id.textView1) ;

        //This code gets the box
          //it gets the bundle of 2 values as sent by login activity

           //First method to extract values of the box
        /*
            String u = box.getStringExtra("U");
            String p = box.getStringExtra("P");
            */

        //2nd method

        Intent box = getIntent();
        Bundle b = box.getExtras();
        String u = b.getString("U");
        String p = b.getString("P");
            tv1.setText("\nLogin Id :" + u + "\n\n Password : " + p);

            if (u.equals(p)) {
                tv1.append("\n\n\nLogin Success"); //append adds at the end of the prv code while set text deletes the prv code and sets it to the new code
            } else {
                tv1.append("\n\n\nLogin Failed");
            }
        }
    }

