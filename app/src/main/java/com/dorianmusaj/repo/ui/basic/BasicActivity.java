package com.dorianmusaj.repo.ui.basic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.utils.CommonUtils;
import com.dorianmusaj.repo.utils.NetworkUtils;

public class BasicActivity extends Activity implements MvpBasicView {

    private ProgressBar mProgressDialog;

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
        if (mProgressDialog != null && mProgressDialog.getVisibility()==View.VISIBLE) {
            mProgressDialog.setVisibility(View.GONE);
        }

        if(error!=null)
            showToast(error, null);

    }

    @Override
    public boolean isNetworkConnected() {
          return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void showToast(String message, @Nullable Integer duration) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
