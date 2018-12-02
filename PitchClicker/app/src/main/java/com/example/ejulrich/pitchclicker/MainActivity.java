package com.example.ejulrich.pitchclicker;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    Button StrikeButton;
    Button BallButton;
    TextView StrikeNum;
    TextView BallNum;
    TextView OutNum;
    Integer StrikeVal = 0;
    Integer BallVal = 0;
    Integer OutVal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrikeButton = (Button) findViewById(R.id.Strike_button);
        BallButton = (Button) findViewById(R.id.Ball_button);
        StrikeNum = (TextView) findViewById(R.id.Strike_textView);
        BallNum = (TextView) findViewById(R.id.Ball_textView);
        OutNum = (TextView) findViewById(R.id.Out_textView);
        // Set the default values
        StrikeNum.setText(StrikeVal.toString());
        BallNum.setText(BallVal.toString());
        OutNum.setText(OutVal.toString());
        // Click listeners
        StrikeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //mTextView.append("1");
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
        BallButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //mTextView.append("1");
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

        // Enables Always-on
        setAmbientEnabled();
    }
}