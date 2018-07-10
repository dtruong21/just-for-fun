package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApi = null;
    private Context context;

    public EndPointAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
