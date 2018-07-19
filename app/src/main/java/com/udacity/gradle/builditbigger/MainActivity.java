package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cake.udacity.cmtruong.com.myjokes.Jokes;
import cake.udacity.cmtruong.com.mylibrary.JokesActivity;

/**
 * @author davidetruong
 * @version 1.0
 * @since July 13th, 2018
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.FLAVOR.equals("free"))
            setTitle("Free");
        else
            setTitle("Paid");

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

    public void tellJoke(View view) {
        EndPointAsyncTask endPointAsyncTask = new EndPointAsyncTask(this);
        endPointAsyncTask.execute();
    }

    /**
     * Function which get the random joke
     *
     * @param view
     */
    // public void tellJoke(View view) {
//        Jokes jokes = new Jokes();
//
//        String joke = jokes.getRandomJoke();
//        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(this, JokesActivity.class);
//        intent.putExtra(JokesActivity.JOKE_INTENT_KEY, joke);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    //   new EndPointAsyncTask(this);
    //  }


}
