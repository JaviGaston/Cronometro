package com.example.cronometro;

public class Cronometer implements ICronometer {
    private ICronometerListener cronometerListener;
    private int seconds;
    private int minutes;
    private int hours;
    private String time;
    private String hoursString;
    private String minutesString;
    private String secondsString;
    private static Cronometer instance;
    private int currentTime = 0;
    private Cronometer(){}

    public static Cronometer getInstance(){
        if (instance == null){
            instance = new Cronometer();
        }
        return instance;
    }

    CronometerTask cronometroTask = new CronometerTask(currentTime);


    @Override
    public void update(int i) {
        currentTime = i;
        hours = i/3600;
        if(hours <10){
            hoursString = "0" + hours;
        }else{
            hoursString = String.valueOf(hours);
        }
        minutes = (i/60)%60;
        if(minutes <10){
            minutesString = "0"+ minutes;
        }else{
            minutesString = String.valueOf(minutes);
        }
        seconds = i%60;
        if(seconds <10){
            secondsString = "0"+ seconds;
        }else{
            secondsString = String.valueOf(seconds);
        }
        time = hoursString +":"+ minutesString +":"+ secondsString;
        cronometerListener.onCronometerTick(time);
    }

    public void setCronometerListener(ICronometerListener setCronometerListener){
        cronometerListener = setCronometerListener;
    }

    public void executeCronometer(){
        cronometroTask.execute();
    }


    public boolean cancelCronometer(){
        boolean ret = cronometroTask.cancel(true);
        cronometroTask = new CronometerTask(0);
        return ret;
    }

    public boolean pauseCronometer(){
        boolean ret = cronometroTask.cancel(true);
        cronometroTask = new CronometerTask(currentTime);
        return ret;
    }


}
