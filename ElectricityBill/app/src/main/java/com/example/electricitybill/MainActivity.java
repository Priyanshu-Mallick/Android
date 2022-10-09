package com.example.electricitybill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView bill;
    private EditText curUnit;
    private EditText preUnit;
    private EditText totUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        bill = findViewById(R.id.bill);
        curUnit = findViewById(R.id.curUnit);
        preUnit = findViewById(R.id.preUnit);
        totUnit = findViewById(R.id.totUnit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You should pay the bill on time", Toast.LENGTH_SHORT).show();
                String s1 = curUnit.getText().toString();
                String s2 = preUnit.getText().toString();

                int un1 = Integer.parseInt(s1);
                int un2 = Integer.parseInt(s2);
                int tot = un1 - un2;

                totUnit.setText(""+tot);

                double bil=0;
                if(tot <= 50)
                {
                    bil = tot * 3.00;
                }
                else if(tot <= 200){
                    bil = 50 * 3.00 + (tot - 50) * 4.80;
                }
                else if(tot <= 400)
                {
                    bil = 50 * 1.20 + 200 * 4.80 + (tot - 250) * 5.80;
                }
                else if(tot>400) {
                    bil = 50 * 1.20 + 200 * 4.80 + 400 * 5.80 + (tot - 650) * 6.20;
                }

                bill.setText("Rs "+bil+" /-");
            }
        });
    }
}