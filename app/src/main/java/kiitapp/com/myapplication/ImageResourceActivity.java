package kiitapp.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

//image name mein only underscore is allowed
//should start from small letter. copy paste it to drawable
//when the image is outside the project we use setImageBitmap
//When its inside the project in the drawable folder= another function is used
public class ImageResourceActivity extends AppCompatActivity
{

    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_resource);
        img1 = (ImageView)findViewById(R.id.imageView1);
        img1.setImageResource(R.drawable.mypic1);
    }
}
