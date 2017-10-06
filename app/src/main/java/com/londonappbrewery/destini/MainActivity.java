package com.londonappbrewery.destini;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TheStory story = new TheStory();
    TextView text;
    Button upButton, downButton;
    int keepTrack=0, pressedButton=0;
    final int[] mStoryIndex = {
            R.string.T1_Story,
            R.string.T1_Ans1,
            R.string.T1_Ans2,
            R.string.T2_Story,
            R.string.T2_Ans1,
            R.string.T2_Ans2,
            R.string.T3_Story,
            R.string.T3_Ans1,
            R.string.T3_Ans2,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        text = (TextView) findViewById(R.id.storyTextView);
        upButton = (Button) findViewById(R.id.buttonTop);
        downButton = (Button) findViewById(R.id.buttonBottom);

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedButton=1;
                story.setTrack(keepTrack, pressedButton);
                keepTrack=story.getmTrack();
                SetStoryText(keepTrack);
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedButton=2;
                story.setTrack(keepTrack, pressedButton);
                keepTrack=story.getmTrack();
                SetStoryText(keepTrack);
            }
        });

    }

    public void SetStoryText(int mKeepTrack) {
        text.setText(mStoryIndex[mKeepTrack]);
        if(mKeepTrack <= 8) {
            upButton.setText(mStoryIndex[mKeepTrack+1]);
            downButton.setText(mStoryIndex[mKeepTrack+2]);
        }
        else {
            upButton.setVisibility(View.GONE);
            downButton.setVisibility(View.GONE);
        }
    }
}
