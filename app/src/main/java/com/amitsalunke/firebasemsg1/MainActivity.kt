package com.amitsalunke.firebasemsg1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.amitsalunke.firebasemsg1.databinding.ActivityMainBinding
import com.amitsalunke.firebasemsg1.model.NotificationData
import com.amitsalunke.firebasemsg1.model.PushNotification
import com.amitsalunke.firebasemsg1.network.RetrofitInstance
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


const val TOPIC = "myTopic"

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        with(mBinding) {
            //val title = mBinding.
            btnSend.setOnClickListener {
                val title = etTitle.text.toString()
                val message = etMessage.text.toString()
                if (title.isNotEmpty() && message.isNotEmpty()) {
                    PushNotification(
                        NotificationData(title, message),
                        TOPIC
                    ).also {
                        sendNotification(it)
                    }
                } else {
                    Log.e(TAG, "Please enter title and msg")
                }
            }
        }

    }

    private fun sendNotification(notification: PushNotification) =
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.postNotification(notification)
                if (response.isSuccessful) {
                    Log.e(TAG, "Is successful ${Gson().toJson(response)}")
                } else {
                    Log.e(TAG, "Error  ${response.code()}")
                }
            } catch (ex: Exception) {
                Log.e(TAG, "Exception while sending the data : " + ex)
            }
        }
}


