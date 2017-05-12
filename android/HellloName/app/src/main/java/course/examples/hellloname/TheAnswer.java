package course.examples.hellloname;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by chiarotti on 11/05/17.
 */

public class TheAnswer extends Activity {
    public final int[] mAnswers = {42, -10, 0, 100, 1000};
    public final int mAnswer = 42;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView answerView = (TextView) findViewById(R.id.answer_view);
        int val = findAnswer();

        String output;
        if(val == mAnswer){
            output = "42";
        }else{
            output = "We may never know";
        }



    }

    private int findAnswer(){
        for(int val : mAnswers){
            if(val == mAnswer){
                return val;
            }
        }
        return -1;
    }
}
