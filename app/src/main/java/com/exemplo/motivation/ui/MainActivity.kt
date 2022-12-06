package com.exemplo.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.exemplo.motivation.R
import com.exemplo.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.hide()

        mBinding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_new_phrase) {

        }
    }
}