package com.udacity.gradle.builditbigger.backend;

import cake.udacity.cmtruong.com.myjokes.Jokes;

public class MyBean {

    private String myData;

    public String getData() {

        Jokes jokes = new Jokes();
        myData = jokes.getRandomJoke();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}
