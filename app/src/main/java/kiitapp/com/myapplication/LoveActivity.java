package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoveActivity extends AppCompatActivity
{
    EditText et1, et2;
    TextView  tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        tv1 = (TextView) findViewById(R.id.textView1);
    }


    public void calculate(View v)
    {
        String s1 =  et1.getText().toString();
        String s2 = et2.getText().toString();
        int len1 = s1.length();
        int len2 = s2.length();
        int res = len1 + len2;
        res%=10;
        res*=10;
        tv1.setText("Love Percentage = "+ res);



    }
}
