package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleSwitchActivity extends AppCompatActivity
{
    //Add text on and text off in toggle button features in the xml text file
    ToggleButton tb1;
    Button btn;
    Switch sw1;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);
        tb1 = (ToggleButton)findViewById(R.id.toggleButton1);
        sw1 = (Switch)findViewById(R.id.switch1);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);

    }
    public void showStatus(View v)
    {
        tv1.setText("Toggle Button : "+tb1.getText());  //get text returns the status of toggle button
        boolean status = sw1.isChecked(); //switch ka status is stored in is checked function
        tv2.setText("Switch Button : "+ status);
    }

}
