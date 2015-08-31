package net.msonic.animationprocessing;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    DialogProcessing processing;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.processing_1);


        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();

        processing = new DialogProcessing();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void btnShowDialog(View v){
        imageView.setVisibility(View.GONE);
        processing.show(getFragmentManager(), "DialogProcessing");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                processing.setMessage(R.string.message_1);

            }
        }, 1000 * 2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                processing.setMessage(R.string.message_2);

            }
        }, 1000 * 4 );


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                processing.setMessage(R.string.message_3);

            }
        }, 1000 * 6 );


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                processing.dismiss();

            }
        }, 1000 * 8 );
    }
}
