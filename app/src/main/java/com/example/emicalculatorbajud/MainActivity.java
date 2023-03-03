package com.example.emicalculatorbajud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText p_amount, r_amount, year;
    Button submit;
    TextView ans,total_i,total_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_amount = findViewById(R.id.p_amount);
        r_amount = findViewById(R.id.r_amount);
        year = findViewById(R.id.year);
        submit = findViewById(R.id.submit);
        ans = findViewById(R.id.ans);
        total_i = findViewById(R.id.t_i);
        total_pay = findViewById(R.id.t_p);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double p = Double.parseDouble(p_amount.getText().toString());
                double r = Double.parseDouble(r_amount.getText().toString());
                int y = Integer.parseInt(year.getText().toString());

                r = r / (12 * 100);

                float final_ans = 1.0f;

                for (int i = 0; i < y; i++) {

                    final_ans *= 1 + r;

                }

                float emi = (float) (p * r * (final_ans / (final_ans - 1)));

                DecimalFormat decimalFormat = new DecimalFormat("0");

                int final_emi = Integer.parseInt(decimalFormat.format(emi));

                ans.setText("EMI " + final_emi);

                int t_p = (int) (final_emi * y);

                total_pay.setText("Total Pay : " + t_p);
                total_i.setText("Total Interest : " + (t_p - p));

            }
        });

    }
}