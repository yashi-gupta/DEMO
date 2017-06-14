package kiitapp.com.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Notes extends AppCompatActivity
{
    EditText et1;
    Button b1, b2;

    File sdcard ;
    String path;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        et1 =(EditText)findViewById(R.id.fileet);
        b1 = (Button)findViewById(R.id.fileread);
        b2 =(Button)findViewById(R.id.filesave);
        sdcard = Environment.getExternalStorageDirectory();  //isse file mili
        //ab path chaiye
        path = sdcard.getPath();
        //now we have the path where we have to write the file
        //this will give us the root. Linux has an mnt named folder
        //mnt is where we access external storage
        //it is linux ka root folder where external storages are eccessed
        //mnt = mount
        //maan ke chalo aa raha hai "/mnt/sdcard0"
        //but aisa hmesha nahi ata
        //jo systrem ka hoga vo humein get path se mil jayega
        //as we are not sure ki developers kis naam se apna sdcard rakhte
        //jo bhi tha, hmein hmare external file ka path aise miljayega hmesha

        //button for read operation
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    FileInputStream fis = new FileInputStream(path+"/rcpl.txt");
                    //100 percent sure ki ye pehli baar mein nahi milegi
                    //to exception ayega
                   // too hum print karte no file data found in catch

                    String data ="";
                    while ((fis.available()>0))
                    {
                        char newchar = (char)fis.read();  //cast it to chgaracter because it returns data in unicode
                        data += newchar;
                    }
                    //now the string data has all the data in the file

                    //so we show it

                    et1.setText(data);
                    //this is permanent as dat is stored in a file



                }
                catch(Exception e)
                {
                    et1.setText("NO FILE DATA FOUND. GHAR JAO");
                }

            }
        });


        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //jo edit text mein likha hoga vahi to write karenge na
                String dtw = et1.getText().toString();
                try {

                    FileOutputStream fos = new FileOutputStream(path + "/rcpl.txt");
                    //this writes it at once
                    //loop bhi laga ke one byte at a time kar sakte the
                    byte[]code=dtw.getBytes();
                    fos.write(code);
                    Toast.makeText(Notes.this,"Data Saved",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    //Ye error ayega jab permission dena bhool jayenge
                    Toast.makeText(Notes.this,"FILE OPERATION FAIL",Toast.LENGTH_LONG).show();
                }


            }
        });



    }
}
