package com.example.emi_callculatorbajud;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amount,intrest,month;

    TextView total,txtemi,txtintrest,calculate;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        intrest = findViewById(R.id.intrest);
        month = findViewById(R.id.month);
        calculate = findViewById(R.id.calculate);
        txtemi = findViewById(R.id.txtemi);
        total = findViewById(R.id.total);
        txtintrest = findViewById(R.id.txtintrest);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int amt = Integer.parseInt(amount.getText().toString());
                double rest = Double.parseDouble(intrest.getText().toString());
                int mon = Integer.parseInt(month.getText().toString());

                double r = rest/(12*100);
                double ans1 = 1;

                for (int i = 0; i <mon ; i++) {
                    ans1 *= (1+r);
                }

                double ans = amt * r * (ans1/(ans1-1));
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(1);
                txtemi.setText("EMI = "+df.format(ans));
                double tamt = ans*mon;
                total.setText("Total amount : "+df.format(tamt));
                double iamt = tamt-amt;
                txtintrest.setText("Intrest Amount : "+df.format(iamt));
            }
        });
    }
}