package kiitapp.com.myapplication;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DemoActivity extends ListActivity
{

    String screens[]={"PHONE CALL","SMS","WEB","WEB SEARCH","PHONEBOOK","MAP SEARCH","EXIT"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,screens);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(screens[position].equals("EXIT"))
        {
            finish();
        }
        else if(screens[position].equals("PHONE CALL")) //IMPLICIT INTENTS
        {
            //First parameter is the name of the calling screen of the OS
            //if we wantto call from the code, we will have to tell which number to call
            //we will have to ledarn the name of all screens
            //OR WE CAN click control plus spacebar and all the options will appear after placing the cursor after intent
            // "tel:" is a prefix which tells that its a telephonic number mentioned for calling

            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9454707555"));
            startActivity(i);
        }
        else if(screens[position].equals("SMS"))
        {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:9415001765"));
            i.putExtra("sms_body","Hello from the other side");
            startActivity(i);
        }
        else if(screens[position].equals("WEB"))
        {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH,Uri.parse("http://www.google.com"));
            startActivity(i);

        }
        else if(screens[position].equals("WEB SEARCH"))
        {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH,Uri.parse("http://www.google.com"));
            i.putExtra(SearchManager.QUERY,"Indian Rail");
            startActivity(i);

        }
        else if(screens[position].equals("PHONEBOOK"))
        {
            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
            startActivity(i);
         }
        else if(screens[position].equals("MAP SEARCH"))
        {
            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=Bhubaneswar"));
            startActivity(i);
        }

    }
    }

