package kiitapp.com.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//wifi and sesor

public class WifiDemo extends AppCompatActivity implements SensorEventListener
{
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_demo);
       tv1 = (TextView)findViewById(R.id.textView2);
        String ssn = Context.SENSOR_SERVICE;
        SensorManager sm = (SensorManager)getSystemService(ssn);
        int sid = Sensor.TYPE_PROXIMITY; //isse hmein sensor ki id mili
        Sensor s = sm.getDefaultSensor(sid);  // 2 or more than two can be used
        //to activate the sdensor, sensor class mein listener activate karte hain.


        //manager sensor pe sensor listener lagata hai, to associate listener with sensor ---
        sm.registerListener(this,s,sm.SENSOR_DELAY_NORMAL); //this will activate the sensor on the current screen
        //first argument - listener kon hai? current class here
        //3rd arg - speed kqaisi raegi
        // there are 3 types of speed
        //Nnormal, fast and Game

        //sensor statistics in notes
    }


    @Override
    public void onSensorChanged(SensorEvent event)
    {
        //event value deta hai- float ki array

        float[] data =event.values;
        int x = (int)data[0];
        //float y = data[1];
        //float z = data[2];
        //for proximity sensor -- String op = "Sensor Status :\n X= "+(int)x+"\nY= "+(int)y+"\nZ ="+(int)z;

        if(x==0||x==3)
        {
            tv1.setText("");
        }
        else {
            tv1.setText("HI User");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}
