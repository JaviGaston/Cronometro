package com.example.cronometro;

public interface ICronometer {
    void update(int i);
    void executeCronometer();

    interface ICronometerListener {
        void onCronometerTick(String time);
    }
}
