package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater(); //its a tool. we fill it with xml file, then it creates graphics
        inflater.inflate(R.menu.myoptionsmenu,menu);  //inserts the xml file we created
        return super.onCreateOptionsMenu(menu); //should be the last line

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this,"Create Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(this,"Edit Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(this,"View Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                Toast.makeText(this,"Delete Clicked",Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
