package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DealConfirmActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1, tv2;
    Button b1, b2;
    String dealStatus = "UnConfirmed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_confirm);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);

        Intent box = getIntent();
        Bundle bundle = box.getExtras();

        tv1.setText(bundle.getString("QUANTITY"));
        tv2.setText(bundle.getString("PRICE"));
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        //7th and last method of event handling
        //easiest method
        b1.setOnClickListener(this); //kept in the same class by "this". inner class isn't used
        b2.setOnClickListener(this);
    }


    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.button1:
                dealStatus = "Order Confirmed";
                break;
            case R.id.button2:
                dealStatus = "Order Rejected";
                break;


        }
        Intent i = new Intent();   //no source or destination is mentioned cuz its already predecided as the source and destination was decided when the control came to this page.
        //This returns intent to the prv page with response code and an extra variable msg
        i.putExtra("msg", dealStatus);
        setResult(0, i); //to compile

        finish();  // terminates the current screen
    }



    }
