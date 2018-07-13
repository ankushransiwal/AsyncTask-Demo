package com.example.android.restful;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);

    }

    public void runClickHandler(View view) {

        myAsyncTask task = new myAsyncTask();
        task.execute("String 1","String 2","String 3");
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }

    private class myAsyncTask extends AsyncTask<String, String, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            for(int i = 0; i <strings.length;i++){
                publishProgress(strings[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            output.append(values[0] + "\n");
        }
    }

}
