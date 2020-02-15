package com.workfort.sera.ui.info.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.workfort.sera.R
import com.workfort.sera.data.constant.Const
import com.workfort.sera.ui.detailsinfo.view.activity.DetailsInfoActivity
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    private var mService: String? = null
    private var mMOS: String? = null
    private var mTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        mService = intent.getStringExtra(Const.Key.SERVICE)
        mMOS = intent.getStringExtra(Const.Key.MOS)
        mTitle = intent.getStringExtra(Const.Key.JOB_TITLE)
        if(mService == null || mMOS == null || mTitle == null) return

        title = mService
        tv_title.text = mTitle

        btn_job_description.setOnClickListener {
            showInfo(
                "Job Description",
                "Job description will be shown here with a very large text"
            )
        }
        btn_similar_jobs.setOnClickListener { gotoDetails() }
        btn_top_abilities.setOnClickListener { gotoDetails() }
        btn_work_activities.setOnClickListener { gotoDetails() }
        btn_work_styles.setOnClickListener {
            showInfo(
                "Work Styles",
                "Work Styles will be shown here with a very large text"
            )
        }
    }

    private fun showInfo(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Got it") {_, _ ->}
            .create()
            .show()
    }

    private fun gotoDetails() {
        val intent = Intent(this, DetailsInfoActivity::class.java)
        intent.putExtra(Const.Key.SERVICE, mService)
        intent.putExtra(Const.Key.JOB_TITLE, mTitle)
        startActivity(intent)
    }
}
