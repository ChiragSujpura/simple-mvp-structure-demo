package com.chiragsujpura.simplemvpstructuredemo.main;


import android.os.CountDownTimer;
import android.util.Log;

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = "Press";

    private MainView mainView;
    private long counter = 60;
    private long totalTime = 60000;
    private CountDownTimer countDownTimer;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void startCountDown() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }

        countDownTimer = new CountDownTimer(totalTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d(TAG, "millis : " + millisUntilFinished);
                totalTime = millisUntilFinished;
                Log.d(TAG, "totalTime : " + totalTime);
                counter = millisUntilFinished / 1000;
                mainView.onTickFire(counter);
            }

            @Override
            public void onFinish() {

                mainView.onFinished();
            }
        };

        countDownTimer.start();

    }

    @Override
    public void onStop() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onReset() {

        countDownTimer.cancel();
        countDownTimer = null;

        totalTime = 60000;
        counter = 60;
        mainView.onReset();
    }

}
