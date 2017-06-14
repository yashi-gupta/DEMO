package kiitapp.com.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AccessData extends AppCompatActivity
{
    TextView tv2,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_data);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1 = (TextView)findViewById(R.id.textView1);
        //String uriaddress = "content://www.kiitstu.com";
        //Uri STU_URI= Uri.parse(uriaddress); //converts string into uri  , iss step se address mil jayega //ab cursor kaise milega?
        Uri PB_URI = ContactsContract.Contacts.CONTENT_URI;

        ContentResolver cr = getContentResolver();
        Cursor p =cr.query(PB_URI,null,null,null,null);

        int cc = p.getColumnCount();   //gives no of columns
        int rc = p.getCount(); //gives no of rows
       //  int i = p.getColumnIndex("name_of_column");

        int nni=p.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
        //To read bphone book we also need a permission., to manifest pe daal do


        int ri = p.getColumnIndex(StuLookup.ROLL_NO);
        int ni = p.getColumnIndex(StuLookup.STU_NAME);

        //last argument mein null ke alawa kuch bhi pass karoge to ascending order mein ayega
        String data = "PHONE BOOK RECORDS : \n";
        tv1.setText(data);
        while (p.moveToNext())
        {
            String r = p.getString(nni);
           // String n = p.getString(ni);
            data = data+r+" : "+"\n";
        }
        tv2.setText(data);

    }
    //helper class
    //aapko column ke naam batati hai
    //they are known as look up classes or contract classes
    //ye milti hain
    //ye humein sab batayega,with the help of cursor. ki kitna data mila hai etc


    //customised CP
    class StuLookup
    {
        public static final String ROLL_NO = "rn";
        public static final String STU_NAME = "name";



    }
}
