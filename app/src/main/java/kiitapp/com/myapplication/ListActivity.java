package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends android.app.ListActivity {
    Button b1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        b1 =(Button)findViewById(R.id.button);
        //similar code we can create for it's deletion
        //context menu se
        //ya fir edit text pe entry leke button se delete kardo
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1 =(EditText)findViewById(R.id.editText);
                String newData = et1.getText().toString();
                if(newData.length()>0)
                {
                    RCPL.data.add(newData);
                }
                et1.setText("");
                getListView().invalidateViews();
            }
        });





        ArrayAdapter<String> adapter = null;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,RCPL.data);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String name = (String)RCPL.data.get(position);
        Toast.makeText(this,name+"Clicked!",Toast.LENGTH_SHORT).show();

    }



}
