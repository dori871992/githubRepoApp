package com.dorianmusaj.repo.ui.basic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.utils.CommonUtils;
import com.dorianmusaj.repo.utils.NetworkUtils;

public class BasicActivity extends Activity implements MvpBasicView {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadingStarted() {
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void loadingFinished(String error) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }

        if(error!=null)
            showSnackBar(error, null);

    }

    @Override
    public boolean isNetworkConnected() {
          return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void showSnackBar(String message, @Nullable Integer duration) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, duration != null ? duration : Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        snackbar.show();
    }
}
