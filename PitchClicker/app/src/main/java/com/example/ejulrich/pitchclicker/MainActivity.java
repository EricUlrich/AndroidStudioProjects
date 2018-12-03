package com.example.ejulrich.pitchclicker;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends WearableActivity {

    private TextView StrikeNum;
    private TextView BallNum;
    private TextView OutNum;
    private TextView InningNum;
    private Integer InningVal = 0;
    private Integer StrikeVal = 0;
    private Integer BallVal = 0;
    private Integer OutVal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button strikeButton = findViewById(R.id.Strike_button);
        Button ballButton = findViewById(R.id.Ball_button);
        Button outButton = findViewById(R.id.Out_button);
        Button inningButton = findViewById(R.id.Inning_button);
        StrikeNum = findViewById(R.id.Strike_textView);
        BallNum = findViewById(R.id.Ball_textView);
        OutNum = findViewById(R.id.Out_textView);
        InningNum = findViewById(R.id.Inning_textView);
        // Set the default values
        StrikeNum.setText(StrikeVal.toString());
        BallNum.setText(BallVal.toString());
        OutNum.setText(OutVal.toString());
        InningNum.setText(InningVal.toString());
        // Click listeners
        strikeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StrikeVal++;
                if ( StrikeVal.equals(3) ){
                    // Will Set out numbers here
                    OutVal++;
                    if (OutVal.equals(3)){
                        OutVal = 0;
                        OutNum.setText(OutVal.toString());
                        BallVal = 0;
                        BallNum.setText((BallVal.toString()));
                    }else {
                        OutNum.setText(OutVal.toString());
                        BallVal = 0;
                        BallNum.setText((BallVal.toString()));
                    }
                    StrikeVal = 0;
                    StrikeNum.setText(StrikeVal.toString());
                    BallVal = 0;
                    BallNum.setText((BallVal.toString()));

                }else{
                    StrikeNum.setText(StrikeVal.toString());
                }
            }
        });
        ballButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BallVal++;
                if ( BallVal.equals(4) ){
                    // Will Set out numbers here
                    StrikeVal = 0;
                    StrikeNum.setText(StrikeVal.toString());
                    BallVal = 0;
                    BallNum.setText((BallVal.toString()));
                }else{
                    BallNum.setText((BallVal.toString()));
                }
            }
        });
        inningButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                InningVal++;
                InningNum.setText((InningVal.toString()));
            }
        });
        outButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OutVal++;
                if ( OutVal.equals(3) ){
                    // If 3 outs are recorded then clear the strike and ball counters_
                    // since the half inning should be over.
                    StrikeVal = 0;
                    StrikeNum.setText(StrikeVal.toString());
                    BallVal = 0;
                    BallNum.setText((BallVal.toString()));
                    OutVal = 0;
                    OutNum.setText((OutVal.toString()));
                }else{
                    // Do not reset the strike and ball counts due to out on bases.
                    // This will need something else as out on bases or by batter not_
                    // being a strike out.
                    //StrikeVal = 0;
                    //StrikeNum.setText(StrikeVal.toString());
                    //BallVal = 0;
                    //BallNum.setText((BallVal.toString()));
                    OutNum.setText((OutVal.toString()));
                }
            }
        });
        // Enables Always-on
        setAmbientEnabled();
    }
}
