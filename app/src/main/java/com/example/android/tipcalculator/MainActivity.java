package com.example.android.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tipTotalText;
    TextView totalText;
    EditText billTotal;
    EditText tipPer;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipTotalText = findViewById(R.id.tipTotal);
        totalText = findViewById(R.id.total);
        billTotal = (EditText) findViewById(R.id.billTotal);
        tipPer = (EditText) findViewById(R.id.tipPer);
        calcBtn = (Button) findViewById(R.id.calcBtn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTip(Double.parseDouble(tipPer.getText().toString()));
            }
        });
    }

    void calculateTip(Double tipPer){

        // Determine the amount of bill

        String billTot = billTotal.getText().toString();

        Double tip = Double.parseDouble(billTot)*tipPer;

        Double total = Double.parseDouble(billTot) + tip;

        // Show amount of tip if bill is typed

        if (!billTotal.getText().equals("")) {
            tipTotalText.setText("Tip - €" + String.format("%.2f", tip));
            totalText.setText("Total - €" + String.format("%.2f", total));
        }
    }

}