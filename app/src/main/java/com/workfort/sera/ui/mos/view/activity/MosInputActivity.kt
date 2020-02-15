package com.workfort.sera.ui.mos.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.workfort.sera.R
import com.workfort.sera.data.constant.Const
import com.workfort.sera.ui.info.view.activity.InfoActivity
import kotlinx.android.synthetic.main.activity_mos_input.*

class MosInputActivity : AppCompatActivity() {

    private var mService: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mos_input)

        mService = intent.getStringExtra(Const.Key.SERVICE)
        if(mService == null) return
        title = mService

        observeEditText(til_mos, et_mos)
        observeEditText(til_mos_title, et_mos_title)

        til_mos.setEndIconOnClickListener { onMosInserted(true) }
        til_mos_title.setEndIconOnClickListener { onMosInserted(false) }
    }

    private fun onMosInserted(isMosCode: Boolean) {
        val mos = if(isMosCode) et_mos.text.toString() else et_mos_title.text.toString()
        if(mos.isEmpty()) return

        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra(Const.Key.SERVICE, mService)
        intent.putExtra(Const.Key.MOS, mos)
        val title = if(isMosCode) "$mService JOB TITLE" else mos
        intent.putExtra(Const.Key.JOB_TITLE, title)

        startActivity(intent)
    }

    private fun observeEditText(inputLayout: TextInputLayout, editText: TextInputEditText) {
        editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                inputLayout.error = if(s.isNullOrEmpty()) "Invalid MOS" else null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
}
