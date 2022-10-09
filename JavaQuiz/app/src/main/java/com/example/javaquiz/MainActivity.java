package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"Java is a person?","Java was introduced in 2020?","Java was using python","Java has abstract classes","Java supports interfaces?"};
    private boolean[] answers = {false,false,false,true,true};
    private int score = 0;
    private int index = 0;
    Button yes;
    Button no;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length-1){
                    if (answers[index]==true){
                        score++;
                    }
                    index++;
                    if (index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score is: "+score, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length-1){
                    if (answers[index]==false){
                        score++;
                    }
                    index++;
                    if (index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score is: "+score, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}