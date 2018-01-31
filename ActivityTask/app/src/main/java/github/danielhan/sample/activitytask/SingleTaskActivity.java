package github.danielhan.sample.activitytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * @author DanielHan
 * @date 2018/1/31
 */

public class SingleTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletask);
        Log.e("task", "method:onCreate,instance:" + this.toString() + ",taskId:" + getTaskId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("task", "method:onNewIntent,instance:" + this.toString() + ",taskId:" + getTaskId());
    }

    public void singletask(View view) {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    public void standard(View view) {
        startActivity(new Intent(this, StandardActivity.class));
    }

}
