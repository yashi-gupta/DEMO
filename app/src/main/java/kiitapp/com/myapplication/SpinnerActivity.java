package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity
{
    Spinner s1,s2;

    void showToast(CharSequence msg)
    {
        Toast.makeText(this , msg ,Toast.LENGTH_SHORT).show();
    }
    String planets[]={"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};
    String gender[]={"Female","Male"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter adapter = new ArrayAdapter(SpinnerActivity.this,android.R.layout.simple_spinner_item,planets);
        ArrayAdapter adapter2 = new ArrayAdapter(SpinnerActivity.this,android.R.layout.simple_spinner_item,gender);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);



        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);

        //For event handling on spinner
        //we attach spinner by another function - setonItemSelectedListener
       s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
       {
           @Override
           public void onItemSelected(AdapterView parent, View view, int position, long id)
           {
               //position stores the position of users choice in the array
               Toast.makeText(SpinnerActivity.this,planets[position], Toast.LENGTH_SHORT).show();



           }

           @Override
           public void onNothingSelected(AdapterView parent)
           {
               showToast("Nothing Selected");

           }
       });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id)
            {
                //position stores the position of users choice in the array
                Toast.makeText(SpinnerActivity.this,gender[position], Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView parent)
            {
                showToast("Nothing Selected");

            }
        });


    }
}
