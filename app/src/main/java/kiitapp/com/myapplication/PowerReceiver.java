package kiitapp.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by user on 9/29/2016.
 */
//to catch it, iska action name pata hona chaiye for writing itin manifest
public class PowerReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String y = "Charger Connected !!"+"\n Detected By Yafi Gupta\nTraining RCPL";
        Toast.makeText(context, y, Toast.LENGTH_SHORT).show();

    }
}
