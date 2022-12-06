package com.exemplo.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.exemplo.motivation.R
import com.exemplo.motivation.constants.Constants
import com.exemplo.motivation.databinding.ActivityMainBinding
import com.exemplo.motivation.infra.SecurityPreference

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var securityPreference: SecurityPreference
    private var category = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.hide()

        handleUserName()

        mBinding.buttonNewPhrase.setOnClickListener(this)
        mBinding.imageAll.setOnClickListener(this)
        mBinding.imageHappy.setOnClickListener(this)
        mBinding.imageSunny.setOnClickListener(this)

        securityPreference = SecurityPreference(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.image_all, R.id.image_happy, R.id.image_sunny -> handleFilter(v.id)
        }
    }

    private fun handleUserName() {
        val name = SecurityPreference(this).getStoredString(Constants.KEY.PERSON_NAME)
        mBinding.textUserName.text = "Olá ${name}"
    }

    private fun handleFilter(id: Int) {

        mBinding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
        mBinding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
        mBinding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            R.id.image_all -> {
                mBinding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = Constants.FILTER.ALL
            }
            R.id.image_happy -> {
                mBinding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = Constants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                mBinding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = Constants.FILTER.SUNNY
            }
        }
    }
}