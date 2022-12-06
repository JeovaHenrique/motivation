package com.exemplo.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.exemplo.motivation.R
import com.exemplo.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.hide()

        mBinding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = mBinding.editName.text.toString()
        if(name != "") {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }else {
            Toast.makeText(this,R.string.validation_mandatory_name,Toast.LENGTH_SHORT).show()
        }
    }
}