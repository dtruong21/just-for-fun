package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import cake.udacity.cmtruong.com.mylibrary.JokesActivity;

/**
 * @author davidetruong
 * @version 1.0
 * @since July 15th, 2018
 */
public class EndPointAsyncTask extends AsyncTask<Context, Void, String> {
    private static final String TAG = EndPointAsyncTask.class.getSimpleName();

    private static MyApi myApi = null;
    private Context context;

    public EndPointAsyncTask() {
    }

//    @Override
//    protected String doInBackground(Pair<Context, String>... pairs) {
//        if (myApi == null) {
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    .setRootUrl("https://just-for-fun-210308.appspot.com/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
//                            request.setDisableGZipContent(true);
//                        }
//                    });
//            myApi = builder.build();
//        }
//        try {
//            return myApi.sayHi("Truong").execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }
//    }

    @Override
    protected String doInBackground(Context... contexts) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://just-for-fun-210308.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
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
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        Log.d(TAG, "onPostExecute: " + s);
    }
}
