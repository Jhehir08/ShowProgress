package com.example.android.showprogress;

import android.os.AsyncTask;
import android.util.Log;

//Create subclass of AsyncTask

public class MyTask extends AsyncTask<Integer, Integer, String> {

    @Override
    protected void onPreExecute() { //PreExecute shows text before thread runs
        super.onPreExecute();
        MainActivity.started.setText("Started");
    }

    @Override
    protected String doInBackground(Integer... params) {
        int progressNum = params[0] * 10;

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(progressNum);
                publishProgress((i + 1) * 10); // same as progress update but runs in background instead of UI
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Done";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int percentage = values[0];

        MainActivity.showProgress.setText(percentage + "%");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        MainActivity.started.setText(s);
        Log.d("MAC_TAG", "Done with AsyncTask");
    }
}
