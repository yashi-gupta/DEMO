package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void click(View view)
    {
        Intent i = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i);
    }

}
