package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import cake.udacity.cmtruong.com.mylibrary.JokesActivity;

/**
 * @author davidetruong
 * @version 1.0
 * @since July 15th, 2018
 */
public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static final String TAG = EndPointAsyncTask.class.getSimpleName();

    private static MyApi myApi = null;
    private Context context;

    public EndPointAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.0.22:8080/_ah/api");
            myApi = builder.build();
        }
        try {
            return myApi.sayHi("Truong").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Intent intent = new Intent(context, JokesActivity.class);
        intent.putExtra(JokesActivity.JOKE_INTENT_KEY, s);
        context.startActivity(intent);

        Log.d(TAG, "onPostExecute: " + s);
    }
}
