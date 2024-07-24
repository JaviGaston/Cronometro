package com.example.cronometro;

import static android.content.ContentValues.TAG;

import android.os.AsyncTask;
import android.util.Log;

public class CronometerTask extends AsyncTask<Void, Float, Boolean> {
public int i = 0;
public CronometerTask(){};

    @Override
    protected Boolean doInBackground(Void... params) {
        Log.i(TAG, "doInBackground: ");
        while (true) {
            publishProgress(Float.valueOf(i));
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("hilo",String.valueOf(i));
            i++;

            if (isCancelled()){
                break;
            }

        }
        return true;
    }
    @Override
    protected void onProgressUpdate(Float... values) {
        Log.d(TAG, "onProgressUpdate() called with: values = [" + values + "]");
        Cronometer.getInstance().update(Math.round(values[0]));
    }



}
