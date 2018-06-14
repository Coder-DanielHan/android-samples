package com.danielhan.transitionsample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    private String flag;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        intent = getIntent();
        if (intent != null) {
            flag = intent.getStringExtra("flag");
        }
        if (!TextUtils.isEmpty(flag)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                switch (flag) {
                    case "explode":
                        getWindow().setEnterTransition(new Explode().setDuration(2000));
                        getWindow().setExitTransition(new Explode().setDuration(2000));
                        break;
                    case "slide":
                        getWindow().setEnterTransition(new Slide().setDuration(2000));
                        getWindow().setExitTransition(new Slide().setDuration(2000));
                        break;
                    case "fade":
                        getWindow().setEnterTransition(new Fade().setDuration(2000));
                        getWindow().setExitTransition(new Fade().setDuration(2000));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void finish() {
        super.finish();
    }
}
