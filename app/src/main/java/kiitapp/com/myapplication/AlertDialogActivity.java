package kiitapp.com.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity
{
    //we create a builder to create a dialog box

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        //Learn three new functions of builder class
        //create se we create a graphic.
        //builder is the inner class of AlertDialog
        //builder has a title and a message
        //create is a function of inner class Builder
        //show is a function of outer class alert dialog
        //Inner class fills all the information
        //outer class is responsible for graphics



        //FOR WHEN WE WANT TO DISPLAY MULTIPLE OPTIONS

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fire Missile");
       final String colors[]={"Red","Blue","Green"};
        builder.setItems(colors, new DialogInterface.OnClickListener()   //code will run for every selectoin.
                // and clicked selection goes to the
            //second variable 'which' in onClick
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(AlertDialogActivity.this,"Selected = "+ colors[which],Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });


      AlertDialog dialog=builder.create();
        dialog.show();

    }
}



/*    CODE FOR A SINGLE MSG
 AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fire Missile");
        builder.setMessage("Are you sure you want to fire the missile?");
        builder.setPositiveButton("Fire", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this,"Missile Fire",Toast.LENGTH_LONG).show();
            }
        }); //First parameter - what to display
        //Second parameter, kya hona hai on clicking the button?
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(AlertDialogActivity.this,"Missile canceled. Peace out.",Toast.LENGTH_LONG).show(); //shift +L for last parameter

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

 */


