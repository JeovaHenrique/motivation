package com.exemplo.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.exemplo.motivation.R
import com.exemplo.motivation.constants.Constants
import com.exemplo.motivation.databinding.ActivityMainBinding
import com.exemplo.motivation.infra.SecurityPreference

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var securityPreference: SecurityPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.hide()

        handleUserName()

        mBinding.buttonNewPhrase.setOnClickListener(this)

        securityPreference = SecurityPreference(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {

        }
    }

    private fun handleUserName() {
        val name = SecurityPreference(this).getStoredString(Constants.KEY.PERSON_NAME)
        mBinding.textUserName.text = "Olá ${name}"
    }
}