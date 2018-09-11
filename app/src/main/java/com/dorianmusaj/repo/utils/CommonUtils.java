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


    public static ProgressBar showLoadingDialog(Context context) {
        ProgressBar progressDialog = new ProgressBar(context);

      /*  progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

       // progressDialog.setContentView(R.layout.progress_dialog);

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);*/

        progressDialog.setVisibility(View.VISIBLE);
        return progressDialog;
    }

}
