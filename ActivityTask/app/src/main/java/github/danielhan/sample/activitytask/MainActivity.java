package github.danielhan.sample.activitytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("task", "method:onCreate,instance:" + this.toString() + ",taskId:" + getTaskId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("task", "method:onNewIntent,instance:" + this.toString() + ",taskId:" + getTaskId());
    }

    public void standard(View view) {
        startActivity(new Intent(this, StandardActivity.class));
    }

    public void singletop(View view) {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    public void singletask(View view) {
        Intent intent = new Intent(this, SingleTaskActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void singleinstance(View view) {
        startActivity(new Intent(this, SingleInstanceActivity.class));
    }
}
