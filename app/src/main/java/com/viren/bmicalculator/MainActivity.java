package com.viren.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHeight, edtHeight2;
        TextView textResult;
        LinearLayout linearLayout;
        linearLayout = findViewById(R.id.bgMain);


        Button getBMI= findViewById(R.id.btnGet);

        edtWeight = findViewById(R.id.edtWeight);
        edtHeight= findViewById(R.id.edtHeight);
        edtHeight2= findViewById(R.id.ediHeight2);

        textResult = findViewById(R.id.textResult);

        Intent healthyIntent = new Intent(MainActivity.this, healthyscreen.class);
        Intent overweightIntent = new Intent(MainActivity.this, overweightscreen.class);

        getBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeight.getText().toString());
                int inch = Integer.parseInt(edtHeight2.getText().toString());

                int totalInc = ft*12 + inch;

                double totalCm = totalInc*2.53;

                double totalM = totalCm/100;

                double BMI = wt/(totalM*totalM);

                if(BMI>25){

//                    textResult.setText(R.string.Overweight);
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.overWt));
                    startActivity(overweightIntent);
                }

                else if(BMI<18){

                    textResult.setText(R.string.Underweight);
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.UnderWt));
                }

                else{

//                    textResult.setText(R.string.Healthy);
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.NormalWt));
                    startActivity(healthyIntent);
                }
            }
        });

    }
}