package com.workfort.sera.ui.splash.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.workfort.sera.R
import com.workfort.sera.ui.main.view.activity.MainActivity

class SplashActivity : AppCompatActivity() {

    private val mHandler = Handler()
    private val mRunnable = Runnable {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        mHandler.postDelayed(mRunnable, 1500)
    }

    override fun onPause() {
        super.onPause()
        mHandler.removeCallbacks(mRunnable)
    }
}
