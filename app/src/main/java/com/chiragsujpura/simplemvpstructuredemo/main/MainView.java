package com.chiragsujpura.simplemvpstructuredemo.main;

import com.chiragsujpura.simplemvpstructuredemo.base.BaseView;

public interface MainView extends BaseView{

    void onTickFire(long m);
    void onFinished();
    void onReset();

}
