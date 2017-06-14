package kiitapp.com.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
{

    TextView t1;
    Button b1;
    Button b2;
    int count = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main); //to merge xml to java
        b1 = (Button) findViewById(R.id.button1);
        t1 = (TextView) findViewById(R.id.textView1);   //shouldnt be before set content
        b2 = (Button) findViewById(R.id.button2);
        KiitClick click = new KiitClick();
        b1.setOnClickListener(click);
        b2.setOnClickListener(click);

    }
//When we need to run a code on clicking a buttonclick

//  We have done the same thing while attaching b1 to an object of onclickListener


    class KiitClick implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.button1) {
                count += 1;
                t1.setText("Counter = " + count);  //Set text to print a value on text fieldB
            } else if (id == R.id.button2) {
                count -= 1;
                t1.setText("Counter = " + count);

            }


        }
    }





        /*
        b1.setOnClickListener(new View.OnClickListener()
        {  //Inline anonymous object has been passed


            @Override
            public void onClick(View v) {
                count += 10;
                t1.setText("Counter = " + count);  //Set text to print a value on text field


            }


        });//End of function

       */

        //ctrl plus spacebar method
      /*
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                count += 1;
                t1.setText("Counter = " + count);
            }
        });
        */



}
