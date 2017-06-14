package kiitapp.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{    EditText et1;
      EditText et2;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button1);
        /*  {
            @Override
            public void onClick(View v) {
                Intent box = new Intent(LoginActivity.this,LoginResultActivity.class);
                //U and P are inner variables of Intent
                box.putExtra("U", et1.getText().toString());  // means U stores user id given through et1
                box.putExtra("P",et2.getText().toString());    //means P stores password given through et2
                startActivity(box);
            }
        }); */
    }
      public void login(View view)
    {
        Intent box = new Intent(LoginActivity.this,LoginResultActivity.class);
        //U and P are inner variables of Intent
        box.putExtra("U", et1.getText().toString());  // means U stores user id given through et1
        //u is an inner variable of box of string type. so is P.
        box.putExtra("P",et2.getText().toString());    //means P stores password given through et2
        //box is not only a bundle of variables, it also contains information of source and destination.
        startActivity(box);
          //Throws the box
    }
}
