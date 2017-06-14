package kiitapp.com.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressDemo extends AppCompatActivity
{
    TextView tv1;
    SeekBar sb1;
    int i;
    ProgressBar pb1;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_demo);


        //dialogue box for when the age opens
         pd = new ProgressDialog(this);
        pd.setTitle("My Activity");
        pd.setMessage("Loading, Please Waiit");
        pd.setCancelable(false); //cant cancel it due to this statement
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.show();



        class LoadThread extends Thread
        {
            public void run()
            {
               //this wwill run for 3 seconds
                for(int i=1;i<100;i++)
                {
                    try
                    {
                        Thread.sleep(50);
                        pd.setProgress(i);
                    }
                        catch(Exception e)
                        {}

                    }
                pd.dismiss();
                }

            }

        LoadThread load =new LoadThread();
        load.start();




        tv1 = (TextView)findViewById(R.id.textView1);
        sb1= (SeekBar)findViewById(R.id.seekBar1);
        sb1.setMax(100); //this is for dynamically setting the max value of seekbar
        tv1.setText("VALUE : 0");//Dynamically setting text view
        /* android:Progress="20" sets progress iin xml */
        pb1 =(ProgressBar)findViewById(R.id.pb1);

        pb1.setMax(100);

        sb1.setProgress(0);//sets progress dynamically
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) //is called whenever
            // the value is changed by the use
                    //eg - for progress 1 to 17, it runs for 17 times
                    //the third argument contains the progress value at any time
            {
                if(fromUser==true)
                i=progress;
                tv1.setText("STATUS : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) //when we hold the tracker,
            // this runs, even if we dont change it
            {
                Toast.makeText(ProgressDemo.this,"SEEK START",Toast.LENGTH_SHORT ).show();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Toast.makeText(ProgressDemo.this,"SEEK STOP",Toast.LENGTH_SHORT ).show();

            }
        });
        class BGTask extends Thread
        {
            public void run()
            {
                for(int i=1;i<=100;i++)
                {
                    try
                    {
                        Thread.sleep(300);//will run till 10 secs
                        //will run till 100 secs if thread.sleep(1000)
                        sb1.setProgress(i);


                    }
                    catch(Exception e)
                    {

                    }

                }

            }
        }
        BGTask t = new BGTask();
        t.start();
        class DownloadThread extends Thread
        {
            public void run()
            {
                for(int i=1;i<=100;i++)
                {
                    try {
                        Thread.sleep(200);
                        pb1.setProgress(i);

                    }
                    catch(Exception e)
                    {}
                }
            }
        }
        DownloadThread d = new DownloadThread();
        d.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.pdm,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.omi1)
            Toast.makeText(this,"Setting clicked",Toast.LENGTH_LONG);
        else
            if (id == R.id.omi2)
                Toast.makeText(this, "Camera clicked", Toast.LENGTH_LONG);

        else
            if (id == R.id.omi3)
                Toast.makeText(this, "Bluetooth clicked", Toast.LENGTH_LONG);
        else
            if(id==R.id.omi4) {
            Toast.makeText(this, "Exit clicked", Toast.LENGTH_LONG);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

