package com.example.mybroadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DownloadService extends IntentService {
    public static final String TAG = "DownloadService";

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.mybroadcastreceiver.action.FOO";
    private static final String ACTION_BAZ = "com.example.mybroadcastreceiver.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.mybroadcastreceiver.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.mybroadcastreceiver.extra.PARAM2";

    public DownloadService() {
        super ( "DownloadService" );
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context , String param1 , String param2) {
        Intent intent = new Intent ( context , DownloadService.class );
        intent.setAction ( ACTION_FOO );
        intent.putExtra ( EXTRA_PARAM1 , param1 );
        intent.putExtra ( EXTRA_PARAM2 , param2 );
        context.startService ( intent );
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context , String param1 , String param2) {
        Intent intent = new Intent ( context , DownloadService.class );
        intent.setAction ( ACTION_BAZ );
        intent.putExtra ( EXTRA_PARAM1 , param1 );
        intent.putExtra ( EXTRA_PARAM2 , param2 );
        context.startService ( intent );
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "Download Service dijalankan");
        if (intent != null) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent notifyFinishIntent = new Intent(MainActivity.ACTION_DOWNLOAD_STATUS);
            sendBroadcast(notifyFinishIntent);
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1 , String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException ( "Not yet implemented" );
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1 , String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException ( "Not yet implemented" );
    }
}
