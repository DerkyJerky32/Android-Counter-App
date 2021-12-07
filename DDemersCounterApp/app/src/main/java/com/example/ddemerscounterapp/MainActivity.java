/*
    Name: DERRICK DEMERS
    Date: 12/6/2021
    Purpose: The purpose of this program is to create a counter application used for Android devices
            This counter application is designed to help the user help keep track of themselves
            counting upwards and downwards by 1 and resetting the counter if need be.
 */

package com.example.ddemerscounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterText;
    private Button minusButton;
    private Button plusButton;
    private Button resetButton;

    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) { //initializing the buttons and what happens on click

            switch(view.getId()) //switch statement to work like a menu
            {
                case R.id.minusButton :
                    subtractCounter(); //if the minus button is clicked, the minus function is used
                    break;

                case R.id.plusButton  :
                    addCounter();      //if the plus button is clicked, the add function is used
                    break;

                case R.id.resetButton :
                    initCounter();     //if the reset button is clicked, the counter will initialize
                    break;              //again back to 0
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterText = (TextView) findViewById (R.id.counterTxt);
        minusButton = (Button) findViewById(R.id.minusButton);
        minusButton.setOnClickListener(clickListener);
        plusButton = (Button) findViewById(R.id.plusButton);
        plusButton.setOnClickListener(clickListener);
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(clickListener);

        initCounter(); //initializing all the buttons with onClickListeners
                        //adding the initialize counter function to begin
    }

    private void initCounter()
    {
        counter = 0;
        counterText.setText(counter + "");
        //counter is set to 0 and added with a blank spot to keep it from crashing
    }

    private void addCounter()
    {
        counter++;
        counterText.setText(counter + "");
        //when the plus button is tapped, this function gets called and adds 1 to the counter
    }

    private void subtractCounter()
    {
        counter--;
        counterText.setText(counter + "");
        ////when the minus button is tapped, this function gets called and subtracts 1 from the counter
    }

}