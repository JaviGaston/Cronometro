package com.example.cronometro;

public interface ICronometer {
    void update(int i);
    void executeCronometer();
    boolean cancelCronometer();

    interface ICronometerListener {
        void onCronometerTick(String time);
    }
}
