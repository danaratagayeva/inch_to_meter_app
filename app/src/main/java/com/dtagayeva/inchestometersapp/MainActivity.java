package com.dtagayeva.inchestometersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();


    }
    private void findViews(){
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }
    private void setupButtonClickListener(){
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double toMetersResult = convertToMeters();
                displayResult(toMetersResult);

            }
        });
    }
    private double convertToMeters(){
        String inchesText=inchesEditText.getText().toString();

        int inches = Integer.parseInt(inchesText);

        double toMeters = inches*0.0254;

        return toMeters;
    }

    private void displayResult(double toMeters){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String MeterTextResult = myDecimalFormatter.format(toMeters);
        String fullResultString;

        fullResultString = MeterTextResult + "m";

        resultTextView.setText(fullResultString);

    }


}