package kiitapp.com.myapplication;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity
{
    ImageView iv1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        iv1 = (ImageView)findViewById(R.id.imageView1);
        Log.d("Testing","Message1");

    }

    public void setWall(View view)
    {
        Log.d("Testing","Message2");
        //WallpaperManager is a class with a private constructor, therefore its object cannot be made
        //a function named getInstance is used to access the wallpaperManager class. This in known as an internal object.
        //the method to create this is called factory method
        // This keyword == getApplicationContext

        //we can take the image from camera
        //we can get it from our own resources from drawable
        //

        WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());

        Drawable d = iv1.getDrawable();
        BitmapDrawable bmd = (BitmapDrawable) d;
        //bitmap drawable is the child class of drawable
        Bitmap b = bmd.getBitmap();

        try
        {
            wm.setBitmap(b);
            Log.d("Testing","Message3");

        }
        catch(IOException e)
        {
            Toast.makeText(this,"Wallpaper not set: "+e,Toast.LENGTH_LONG).show();
            Log.d("Testing","Message4"+e.toString());
        }

    }
}
