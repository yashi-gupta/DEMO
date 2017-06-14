package kiitapp.com.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuDemoActivity extends AppCompatActivity
{
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);
        b1=(Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuDemoActivity.this, "HELLO!", Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(b1); //for registering the method for context menu
        //pehli baar mein this will behave differently
        //this is done byy shared preferences

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        SharedPreferences sp = getSharedPreferences("SAY HI",MODE_PRIVATE);
        boolean ft = sp.getBoolean("firsttime",true);
        if(ft==true) //sirf pehli baar
        {
            Toast.makeText(this,"WELCOME TO THIS PAGE!!",Toast.LENGTH_LONG).show();
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("firsttime",false);
            e.commit();
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.setHeaderIcon(android.R.drawable.ic_delete);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.cmd,menu);  //ON clicking
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.cmi1)
        {
            b1.setVisibility(View.INVISIBLE);
        }
        else if(id==R.id.cmi4)
        {
            String d = "This is android.widget.Button for Context Menu";
            Toast.makeText(this,d,Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"CLICK EXIT TO LEAVE",Toast.LENGTH_LONG).show();
    }
}

