package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

//we use radio group - in container
//Radio group makes the buttons mutually exclusive. that is, only one can be selected at a time. reffered to as radioGroup1
//check xml file of group id.
public class RadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    RadioGroup rg1;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        tv = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button1);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener(this);  //this means code exits in the same class
        btn.setOnClickListener(this);
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        String str = "You have selected :";
        switch(checkedId)
        {
            case R.id.radioButton1: str = str +" Breakfast";
                break;
            case R.id.radioButton2:  str = str +" Lunch";
                break;
            case R.id.radioButton3:  str = str +" Dinner";
                break;
            case R.id.radioButton4:  str = str +" All";
                break;

        }
        tv.setText(str);
    }

    @Override
    public void onClick(View v)
    {
        rg1.clearCheck();
        tv.setText("You have selected : (none)");


    }
}
