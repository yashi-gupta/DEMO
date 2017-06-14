package kiitapp.com.myapplication;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class BTDemo extends AppCompatActivity
{

    Switch sw1;
    BluetoothAdapter bt;
    //oncheckchangelisterener ---FOR SWITCH
    //discover hum setting pe bhi karsakte
    //but we want to access this from the app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btdemo);
        sw1 = (Switch)findViewById(R.id.switch1);

        bt = BluetoothAdapter.getDefaultAdapter();  //Object aise banta hai
        if(bt!=null) //that means we got bluetooth
        {
            if(bt.isEnabled())
            {
                sw1.setChecked(true);
            }

        }
        else
        {
            //DEVICE NOT RESPONDINGG or access must be denied (jab permission na li ho)
        }



        //Manual on-off Bluetooth

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnOff();
            }
        });

    }

    void doOnOff()
    {
        if(sw1.isChecked())
        {
            bt.enable();
        }
        else
        {
            bt.disable();
        }
    }




    public void open(View v)
    {
        //intent action name get karo in a string, like in camera
        String btSettingAction = Settings.ACTION_BLUETOOTH_SETTINGS;
        Intent settingsIntent  = new Intent(btSettingAction);
        startActivity(settingsIntent);

    }


    public void discover(View v)
    {
        if(bt.isEnabled())
        {
            if(bt.isDiscovering()==false)
            {
                String devNames = "DEVICE FOUND :\n";
                Set<BluetoothDevice> devices  = bt.getBondedDevices();
                for(BluetoothDevice d : devices)
                {
                    devNames += d.getName() + "\n";
                }


                //bt.startDiscovery()
                //bt.cancelDiscovery()

                //dynamic message show karega
                Dialog d = new Dialog(this);
                d.setTitle("Discovery Result");
                TextView data = new TextView(this);
                data.setText(devNames);
                d.setContentView(data);
                d.show();
            }
        }
        else
        {
            Toast.makeText(this,"Please Enable Device",Toast.LENGTH_SHORT).show();
        }

    }
}
