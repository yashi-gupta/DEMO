package kiitapp.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by user on 9/29/2016.
 */
public class MyReciever extends BroadcastReceiver
{
    //broadcast object we get in the function argument = in i


    @Override
    public void onReceive(Context c, Intent i)
    {
        Bundle b = i.getExtras();
        String info = b.getString("INFO"); // we will have to reem,ber the key  or we can take the help of a helper class as made below
        String type = b.getString(ExamManager.EXTRA_EXAM_TYPE);
        String marks = b.getString(ExamManager.EXTRA_EXAM_MARKS);

        String op = "EXAM DETAILS:\n";
        op += "INFO   :  "+info+"\n";
        op += "TYPE   :  "+type+"\n";
        op += "MARKS   :  "+marks+"\n";



        Toast.makeText(c,op,Toast.LENGTH_LONG).show();
    }

    //system wala use karaengeto bana banaya helper class milega
    static class ExamManager
    {
        public static final String EXTRA_EXAM_INFO = "INFO";
        public static final String EXTRA_EXAM_TYPE = "TYPE";
        public static final String EXTRA_EXAM_MARKS = "MARKS";

    }
}
//as its a short process , it has only one method


//2