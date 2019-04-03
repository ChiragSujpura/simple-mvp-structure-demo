
package com.chiragsujpura.simplemvpstructuredemo.base;


public interface BaseView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

}
