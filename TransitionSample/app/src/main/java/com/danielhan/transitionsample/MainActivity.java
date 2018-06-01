package com.danielhan.transitionsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                ActivityCompat.startActivity(MainActivity.this, intent,
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, btn, "btn").toBundle());
            }
        });
    }


    public void explode(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", "explode");
        ActivityCompat.startActivity(MainActivity.this, intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public void slide(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", "slide");
        ActivityCompat.startActivity(MainActivity.this, intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public void fade(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", "fade");
        ActivityCompat.startActivity(MainActivity.this, intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

}
