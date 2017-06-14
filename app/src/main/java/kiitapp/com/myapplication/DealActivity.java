package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DealActivity extends AppCompatActivity
{
    EditText et1, et2;
    Button b1;
    public static final int REQUEST_CODE =6;  //Any static and final variable is always on caps on

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
    }


    public void deal(View view)
    {
        Intent box = new Intent(DealActivity.this,DealConfirmActivity.class);

        //U and P are inner variables of Intent
        box.putExtra("QUANTITY", et1.getText().toString());  // means U stores user id given through et1
        box.putExtra("PRICE",et2.getText().toString());    //means P stores password given through et2
        startActivityForResult(box,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) //we dont need to catch intent by second screen bevause we get it through this function
    {
        super.onActivityResult(requestCode, resultCode, data);
        String str = data.getExtras().getString("msg");
        Toast.makeText(this,str, Toast.LENGTH_LONG).show();
    }
}
