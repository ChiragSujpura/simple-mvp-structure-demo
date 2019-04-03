package com.chiragsujpura.simplemvpstructuredemo.base;

import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.chiragsujpura.simplemvpstructuredemo.utils.KeyboardUtils;
import com.chiragsujpura.simplemvpstructuredemo.utils.NetworkUtils;


public class BaseFragment extends Fragment implements BaseView {
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void onError(String message) {
        try {
            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean isNetworkConnected() {
        boolean b = NetworkUtils.isNetworkConnected(getContext());
        if (!b)
            Toast.makeText(getContext(), "No Internet Connected,Please check", Toast.LENGTH_LONG).show();
        return b;
    }

    @Override
    public void hideKeyboard() {
        KeyboardUtils.hideSoftInput(getActivity());
    }

    public String getUniqueID() {
        String android_id = Settings.Secure.getString(getActivity().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }
}
