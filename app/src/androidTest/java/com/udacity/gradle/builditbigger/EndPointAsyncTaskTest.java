package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest {

    @Test
    public void checkEndpointsAsyncTask() {
        EndPointAsyncTask endPointAsyncTask = new EndPointAsyncTask();
        try {
            String mJoke = endPointAsyncTask.execute().get();
            assertFalse(mJoke.isEmpty());
            assert mJoke.length() > 0;
            assertNotNull(mJoke);
            assertTrue(mJoke.length() > 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}