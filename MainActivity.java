package com.example.android.showprogress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView started;
    static TextView showProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        started = (TextView) findViewById(R.id.textView);
        showProgress = (TextView) findViewById(R.id.textView2);
    }

    public void startAST(View view) {
        MyTask newTask = new MyTask(); // new object of Async class
        newTask.execute(12); // sends to doInBackGround
    }

}
