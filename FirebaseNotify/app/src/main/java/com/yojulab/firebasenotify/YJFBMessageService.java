package com.yojulab.firebasenotify;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class YJFBMessageService extends FirebaseMessagingService {
    public YJFBMessageService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("YJFBMessageService", "Title : "+remoteMessage.getNotification().getTitle());
        Log.d("YJFBMessageService", "message : "+remoteMessage.getNotification().getBody());
    }
}
