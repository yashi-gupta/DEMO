package kiitapp.com.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class CalculatorActivity extends AppCompatActivity
{
    EditText et1, et2;
    TextView tv1, tv2, tv3;
    Button b1, b2, b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);



    }

    public void add(View v)
    {
        int a = Integer.parseInt(et1.getText().toString());
        int b = Integer.parseInt(et2.getText().toString());
        int res = a+b;
        tv3.setText("Addition Result = "+ res);


    }

    public void sub(View v)
    {
        int a = Integer.parseInt(et1.getText().toString());
        int b = Integer.parseInt(et2.getText().toString());
        int res = a-b;
        tv3.setText("Substraction Result = "+ res);
     }

    public void clear(View v)
    {
        et1.setText("");
        et2.setText("");
        tv3.setText("");
    }
}
