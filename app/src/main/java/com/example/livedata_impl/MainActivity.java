package com.example.livedata_impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModel_MainActivity viewModel_mainActivity = new ViewModelProvider(this).get(ViewModel_MainActivity.class);

        final TextView textView1 = findViewById(R.id.textView1);

        MutableLiveData<Integer> liveCount = viewModel_mainActivity.getInitialCount();
        liveCount.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView1.setText("You clicked me " + integer + " times!");
            }
        });

        final Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel_mainActivity.increaseCount();
            }
        });
    }
}