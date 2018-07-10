package cake.udacity.cmtruong.com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Activity to display the joke as an library
 *
 * @author davidetruong
 * @version 1.0
 * @since July 10th, 2018
 */
public class JokesActivity extends AppCompatActivity {

    public static final String JOKE_INTENT_KEY = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        String joke = getIntent().getStringExtra(JOKE_INTENT_KEY);
        TextView tv_joke = findViewById(R.id.tv_joke);
        tv_joke.setText(joke);
    }
}
