package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Contact o1 = new Contact(1, "9937991865", "Guddu");
    Contact o2 = new Contact(2, "2345678345", "nmfgfm");
    Contact o3 = new Contact(3, "3456734564", "Gjhfn");
    Contact o4 = new Contact(4, "1234567890", "srtifh");
    Contact o5 = new Contact(5, "5627347832", "srtjses");
    Contact o6 = new Contact(6, "2456098458", "jkras");
    Contact o7 = new Contact(7, "0984289983", "setjjra");
    Contact o8 = new Contact(8, "0872458873", "srjytue");
    Contact o9 = new Contact(9, "0962456985", "tukrtyu");
    Contact o10 = new Contact(10, "9832670327", "ryjkrt");

    Contact [] contacts = {o1,o2,o3,o4,o5,o6,o7,o8,o9,o10};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter ad = new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}