package kiitapp.com.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//extends list activity,
//delte the set content view wali line
public class CustomListActivity extends ListActivity
{

    String []nameArray={"Batman","Superman","Arrow","Iron Man","Spider Man","Captain America"};
    String []infoArray = {"Bruce Wayne","Clark Kent","Oliver Queen","Tony Stark","Peter IDontRemember","Steve Rogers"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ArrayAdapter adpt = null;
        adpt = new MyAdapter(this,android.R.layout.simple_list_item_1,nameArray);
        setListAdapter(adpt);
    }
    class MyAdapter extends ArrayAdapter
    {
        //theres a tool to find out the parent of string
        //cmd mein =  javap java.lang.String
//for every element of object array, get view will run
        public MyAdapter(Context context, int resource, String []objects) //string ki parenthoti hai object
        {
            super(context, resource, objects);
        }
//we override get view of arrayAdapter class, check copy for diagram
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //position = position of array element
            //this function will pick the first value of array
            //we give it the theme of a single row
            //it implements that theme, makes a row graphic and returns back to OS
            //OS prints it on screen
            //we make an xml file
            //supply data to this function
            //and create the custom list
            //this code runs for every element in the array
            View row=null;
            LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //OS uses this service to display graphic
            //We customise the theme and use that service to display our theme
            //only one function to get system services and modiffy it
            //we can either learn all the names of internal services
            //or you press ctrl plus space after context.
           row =  li.inflate(R.layout.activity_custom_list,parent,false);
            ImageView iv = (ImageView)row.findViewById(R.id.imageView);  //row - pehli line ka variable
            //xml se row bana

            TextView tv1 = (TextView)row.findViewById(R.id.textView1);
            TextView tv2 = (TextView)row.findViewById(R.id.textView2);
            tv1.setText(nameArray[position]);
            tv2.setText(infoArray[position]);

            if(position%2==0)
                iv.setImageResource(android.R.drawable.star_big_on);
            else
                iv.setImageResource(android.R.drawable.star_big_off);

            return row;

        }
    }//end of my adapter

}
