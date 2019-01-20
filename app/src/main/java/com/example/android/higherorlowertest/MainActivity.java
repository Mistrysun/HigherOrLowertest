package com.example.android.higherorlowertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

        String message;

        if (numberGuessed.getText().toString().isEmpty()) {

            message = "Please enter a number";

        } else {

            int valueGuessed = Integer.parseInt(numberGuessed.getText().toString());

            if (valueGuessed < randomNumber) {
                message = "Higher!";
            } else if (valueGuessed > randomNumber) {
                message = "Lower!";
            } else {
                message = "You got it! Here we go again!";
                GenerateRandomNumber();
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Entered Value", numberGuessed.getText().toString());

        Log.i("Random Number", Integer.toString(randomNumber));

        numberGuessed.getText().clear();
    }
}
