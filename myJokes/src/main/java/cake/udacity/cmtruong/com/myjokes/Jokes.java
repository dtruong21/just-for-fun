package cake.udacity.cmtruong.com.myjokes;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {

    private ArrayList<String> jokesList;


    public Jokes() {
        jokesList = new ArrayList<>();
        jokesList.add("99 bugs in the code,\n" +
                "Fix one bug, compile it again,\n" +
                "101 bugs in the code.");
        jokesList.add("Q: What is the difference between Android 2.1 and 2.2?\n" +
                "A: 6 months");
        jokesList.add("Q: Definition of an upgrade?\n" +
                "A: Take old bugs out, put new ones in.");
        jokesList.add("An Android app walks into a bar. Bartender asks, “Can I get you a drink?” The app looks disappointed and says, “That wasn’t my intent.”");
        jokesList.add("Q: “Whats the object-oriented way to become wealthy?”\n" +
                "A: Inheritance");
        jokesList.add("To understand what recursion is, you must first understand recursion.");
        jokesList.add("The fantastic element that explains the appeal of games to many developers is neither the fire-breathing monsters nor the milky-skinned, semi-clad sirens; it is the experience of carrying out a task from start to finish without any change in the user requirements.");
    }

    public ArrayList<String> getJokes() {
        return jokesList;
    }

    public String getRandomJoke() {
        String randomJoke = jokesList.get(new Random().nextInt(jokesList.size()));
        return randomJoke;
    }
}
