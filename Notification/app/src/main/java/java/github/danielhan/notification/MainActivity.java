package java.github.danielhan.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private NotificationCompat.Builder mNotifyBuilder;
    private int numMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification(MainActivity.this);
            }
        });
    }

    public static void createNotification(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // TODO: 2018/5/14 notification channel
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("This is title!")
                .setContentText("Thie is content!")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Prelude.ogg")))
//                // TODO: 2018/5/14 震动没有循环
//                .setVibrate(new long[]{0, 1000, 1000, 100})
//                .setLights(context.getResources().getColor(R.color.colorAccent), 1000, 1000)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                // TODO: 2018/5/16 max priority 并没有弹出横幅
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    public void createBigTextNotification(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // TODO: 2018/5/14 notification channel
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("This is title!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Thie is content!Thie is content!Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!" +
                        "Thie is content!Thie is content!Thie is content!"))
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Prelude.ogg")))
//                // TODO: 2018/5/14 震动没有循环
//                .setVibrate(new long[]{0, 1000, 1000, 100})
//                .setLights(context.getResources().getColor(R.color.colorAccent), 1000, 1000)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    public void createBigPictureNotification(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // TODO: 2018/5/14 notification channel
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("This is title!")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)))
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    public void createNotification1(Context context) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, NotificationActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(NotificationActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(2, mBuilder.build());
    }

    public void updateNotification() {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Sets an ID for the notification, so it can be updated
        int notifyID = 1;
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("New Message")
                .setContentText("You've received new messages.")
                .setSmallIcon(R.drawable.ic_launcher);
        mNotifyBuilder.setContentText("New Messages")
                .setNumber(++numMessages);
        // Because the ID remains unchanged, the existing notification is
        // updated.
        mNotificationManager.notify(
                notifyID,
                mNotifyBuilder.build());
    }
}
