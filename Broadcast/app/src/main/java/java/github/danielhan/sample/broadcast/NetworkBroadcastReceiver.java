package java.github.danielhan.sample.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean connected = NetworkUtils.isConnected(context);
        if (connected) {
            NetworkUtils.NetworkType networkType = NetworkUtils.getNetworkType(context);
            Toast.makeText(context, "network is connected " + networkType.name(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "network is unconnected", Toast.LENGTH_SHORT).show();
        }
    }
}
