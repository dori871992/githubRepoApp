package com.dorianmusaj.repo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.dorianmusaj.repo.ui.main.MainActivity;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        launchMainActivity();
    }


    private void launchMainActivity() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }

}
