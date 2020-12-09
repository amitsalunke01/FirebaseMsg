package com.amitsalunke.firebasemsg1

import com.amitsalunke.firebasemsg1.BuildConfig

class Constants {
    companion object {
        const val BASE_URL = "https://fcm.googleapis.com"
        const val SERVER_KEY = BuildConfig.FIREBASE_MSG_KEY

        //"AAAAbL447rQ:APA91bEspe5AEAEwuLub0dBsQMHurQSM1Y82lRB9F7NvY3nLtptnFlDeMnICwptDUAU0qVt9FLKXqkPSZKcLgxmms-u5n3_ifsRUgQdgcvXnNfjhV8CKON402BFQ9SDhOolN9Fsh6W5g"
        const val CONTENT_TYPE = "application/json"
    }
}
/*
<service
            android:name=".java.MyFirebaseMessagingService"
            android:exported="false">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
            </intent-filter>
        </service>
* */