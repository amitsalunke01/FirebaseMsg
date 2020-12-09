package com.amitsalunke.firebasemsg1.model

data class PushNotification(
    val data: NotificationData,
    val to: String
)