package com.wu.jonathan.timer;

import android.os.CountDownTimer;

/**
 * Created by Jonathan on 2/6/17.
 */
public class TimerSingleton {
    View view;
    CountDownTimer timer;
    int startTime = 0;
    int currentTime = 0;
    boolean canceled = true;

    void stop() {
        cancel();
    }
    void start() {
        if (canceled) {
            initCountDownTimer(currentTime);
            view.onSet(currentTime);
            timer.start();
            canceled = false;
        }
    }
    void clear() {
        view.hideMeme();
        cancel();
        setTime(0);
    }
    void setView(View view) {
        this.view = view;
    }
    void setTime(int time) {
        this.startTime = time;
        initCountDownTimer(time);
        view.onSet(time);
        view.hideMeme();
    }
    void initCountDownTimer(int time) {
        cancel();
        this.currentTime = time;
        this.timer = new CountDownTimer(time * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                currentTime = (int) millisUntilFinished / 1000;
                int difference = startTime - currentTime;
                if (difference % 10 == 0){
                    view.onToast(difference);
                }
                view.onSet(currentTime);
            }
            public void onFinish() {
                view.showMeme();
            }
        };
    }
    void cancel() {
        if(timer != null) {
            this.timer.cancel();
            canceled = true;
        }
    }

    private static TimerSingleton ourInstance = new TimerSingleton();

    public static TimerSingleton getInstance() {
        return ourInstance;
    }

    private TimerSingleton() {

    }
    public interface View {
        public void onSet(int time);
        public void onToast(int time);
        public void showMeme();
        public void hideMeme();

    }

}
