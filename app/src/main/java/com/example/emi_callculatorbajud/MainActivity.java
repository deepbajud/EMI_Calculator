package com.example.emi_callculatorbajud;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amountEditText, interestEditText, monthsEditText;
    TextView emiTextView;
    Button calculateButton;
    ImageView appLogoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amount);
        interestEditText = findViewById(R.id.interest);
        monthsEditText = findViewById(R.id.months);
        calculateButton = findViewById(R.id.calculateButton);
        emiTextView = findViewById(R.id.emis);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double principal = Double.parseDouble(amountEditText.getText().toString());
                double interestRate = Double.parseDouble(interestEditText.getText().toString());
                int months = Integer.parseInt(monthsEditText.getText().toString());

                double monthlyInterestRate = interestRate / (12 * 100);
                double denominator = Math.pow(1 + monthlyInterestRate, months) - 1;
                double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / denominator;

                DecimalFormat df = new DecimalFormat("#.##");
                emiTextView.setText("EMI: " + df.format(emi));
            }
        });
    }
}
