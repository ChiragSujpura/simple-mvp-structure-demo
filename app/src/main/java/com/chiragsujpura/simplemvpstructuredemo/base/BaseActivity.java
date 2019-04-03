package com.chiragsujpura.simplemvpstructuredemo.base;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chiragsujpura.simplemvpstructuredemo.utils.CommonUtils;
import com.chiragsujpura.simplemvpstructuredemo.utils.NetworkUtils;

public class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void showLoading() {
        CommonUtils.showLoadingDialog(this).show();
    }

    @Override
    public void hideLoading() {
        CommonUtils.dismissProgressDialog();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean isNetworkConnected() {
        boolean b = NetworkUtils.isNetworkConnected(this);
        if (!b)
            Toast.makeText(this, "No Internet Connected,Please check", Toast.LENGTH_LONG).show();
        return b;
    }

    @Override
    public void hideKeyboard() {

    }

    public void toastMessage(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_LONG).show();
    }

    public String getUniqueID() {
        String android_id = Settings.Secure.getString(BaseActivity.this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }
}
