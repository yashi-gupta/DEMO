package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class ClockDemo extends AppCompatActivity
{
    TextView tv1;
    String f;

    //Thread can only touch progress bar and seek bar
    //it cannot touch any view
    //independent thread has no access to change the view
    //Theres a spcl thread inside the thread class to change view - Android UI Thread
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_demo);
        tv1 = (TextView)findViewById(R.id.textView2);




        class LiveTime extends Thread
        {
            public void run()
            {


                while(true) {
                    Date d = new Date();

                   f = String.format("%tr", d);
                    //As normal thread cannot touch the text, the special thread _android ui thread is used to change the text
                    //whenever we need to change the text we write that code inside the runOnUiThread block
                    //text view ko dynamically change karana hai, this is the only way
                    //Runnable is an interface
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv1.setText(f);
                        }
                    });
                    try
                    {
                        Thread.sleep(1000);

                    }
                    catch(Exception e)
                    {}
                }

            }
        }

        LiveTime t = new LiveTime();
        t.start();
    }
}
