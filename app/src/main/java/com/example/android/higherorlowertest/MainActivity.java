package com.example.android.higherorlowertest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GenerateRandomNumber();
    }

    public void GenerateRandomNumber() {
        Random rand = new Random();

        randomNumber = rand.nextInt(20) +1;
    }

    public void GenerateOnClick (View view) {

        EditText numberGuessed = (EditText) findViewById(R.id.numberEditText);

        TextView clueTextView = (TextView) findViewById(R.id.clueTextView);

        String message;

        if (numberGuessed.getText().toString().isEmpty()) {

            message = "Please enter a number";

        } else {

            int valueGuessed = Integer.parseInt(numberGuessed.getText().toString());

            if (valueGuessed < randomNumber) {
                message = "Higher!";
                clueTextView.animate().rotationBy(3600);

            } else if (valueGuessed > randomNumber) {
                message = "Lower!";
                clueTextView.animate().rotationBy(-3600);

            } else {
                message = "You got it!";
                GenerateRandomNumber();
            }
        }

        clueTextView.setText(message);
        clueTextView.setAlpha(1);

        Log.i("Entered Value", numberGuessed.getText().toString());

        Log.i("Random Number", Integer.toString(randomNumber));

        numberGuessed.getText().clear();
    }
}
