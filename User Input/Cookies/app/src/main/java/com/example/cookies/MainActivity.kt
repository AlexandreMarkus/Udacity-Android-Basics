package com.example.cookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eat_button.setOnClickListener {
            android_cookie_image_view.setImageResource(R.drawable.after_cookie)
            status_text_view.text = getString(R.string.i_m_so_full)
        }
    }
}
