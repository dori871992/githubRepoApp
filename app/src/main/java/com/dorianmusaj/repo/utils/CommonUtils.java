package com.dorianmusaj.repo.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.dorianmusaj.repo.R;

public class CommonUtils {


    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context,  R.style.MyGravity);

        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();
        return progressDialog;
    }

}
