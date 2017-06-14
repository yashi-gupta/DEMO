package kiitapp.com.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class DateTimeActivity extends AppCompatActivity
{
    //use on click on edit text. we can use on click on any type
    EditText et1;
    String str; //stores the date time entered in the calender
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        et1 = (EditText)findViewById(R.id.editText1);
    }

    class MyDateChooser implements DatePickerDialog.OnDateSetListener
    {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            str = year +"-"+(month+1)+"-"+dayOfMonth;  //month +1 because 0 is for jan 1 is for feb and so on
            et1.setText(str);


        }
    }

    public void showDateChooser(View view)
    {
        DatePickerDialog dialog = new DatePickerDialog(DateTimeActivity.this, new MyDateChooser(),2016,0,0);
        dialog.show();
    }


}
