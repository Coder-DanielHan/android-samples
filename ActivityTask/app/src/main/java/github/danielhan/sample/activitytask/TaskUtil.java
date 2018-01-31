package github.danielhan.sample.activitytask;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * @author DanielHan
 * @date 2018/1/31
 */

public class TaskUtil {

    /**
     * 获取所有
     *
     * @param context
     * @param num     最大数
     * @return
     */
    public static List<ActivityManager.RunningTaskInfo> getRunningTask(Context context, int num) {
        if (context != null) {
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> rTasks = am.getRunningTasks(num);
            return rTasks;
        }
        return null;
    }
}
