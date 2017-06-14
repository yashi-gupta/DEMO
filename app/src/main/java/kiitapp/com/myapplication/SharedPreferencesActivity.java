package kiitapp.com.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity
{
    //onCreate runs when screen opens for the first time
    //on stop function is executed just when the screen is terminated
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et1 =(EditText)findViewById(R.id.editText1);
        //get shared preferences = to open the file, to read or write it. hence its used in both oncreate and on stop
        SharedPreferences sp= getSharedPreferences("DemoFile",0);  //0 means - mode private. iss file ko aur koi load nahi karsakta
        //the first time we call it, it won't exist.
        String msg =sp.getString("STATUS",null); //2nd parameter is alternate value, executed when the file is not created,
        // that is when on create runs
        //for the first time
        //edit text will appear blanks for the first time
        //because when it executes for the first time the file doesn't exist
        et1.setText(msg);

    }

    @Override
    protected void onStop() //to get the file and write it in editable mode
    {
        super.onStop();
        //as shared preferences is needed to load the file
        SharedPreferences sp= getSharedPreferences("DemoFile",0); //when this runs for the first time, it creates a file name demo file
        //thus edit function has two functions-
        //to open a pre existing file
        //or to create a new file
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("STATUS",et1.getText().toString()); //creates an inner variable in the file,
        // and assigns the value of second parameter to it
        //status is the key
        //value we get from et1.getText
        //if status already exists, then it changes it's value to what we've entered in the second parameter
        editor.commit();  //this line saves the file
    }
}
