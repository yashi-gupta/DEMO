package kiitapp.com.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity
{
    String screens[] = {"SettingsActiivity","BroadcastDemo","Access Data","Notes","MusicDemo","ClockDemo","MainActivity","CustomListActivity","ProgressDemo","WallpaperActivity","ImageResourceActivity","ToggleSwitchActivity","CalculatorActivity","LoginActivity","RadioActivity","Main2Activity","Main3Activity","LoveActivity","LoginResultActivity","DemoActivity","AlertDialogActivity","EXIT"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,screens);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {    //position contains the position of the array element which has been clicked
        super.onListItemClick(l, v, position, id);
        if(screens[position].equals("EXIT"))
        {
            finish();  //To self terminate any screen, this function is used
        }
        else
        {  //to send the control from here to another activity, we need send intent, whose sender/source is always
            // the main or menu activity
            //But the receiver is the acrivity that we want to open
            //kiitapp.com.myapplication is the name of the package. it is the first name of every activity
            String str = "kiitapp.com.myapplication" + "."+screens[position];  // This store the activity which has been clicked
            //Destination file name stored in a string

            try
            {
                Class c = Class.forName(str);  // This removes double quotes from a string and converts it to a class name
                //it creates a .class file
                //forName function converts a name given, the file which exists already, and converts it to .class file
                //This line may produce error, since it is not necessary that there exists a file already with the same name as str
                Intent i = new Intent(MenuActivity.this,c);
                startActivity(i);




            }
            catch (ClassNotFoundException e)
            {
                Toast.makeText(MenuActivity.this,"Screen not yet assigned ",Toast.LENGTH_SHORT).show();

                //LENGTH_SHORT is a public and static data member. industry standard, a public static and final variable is saved in caps on.
            }

            }
        }
}
