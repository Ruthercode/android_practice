package com.example.pagislavapp.ui.login

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.pagislavapp.ui.main.MainActivity


const val WEB_SITE = "web.site"
const val USERNAME = "user.name"

class LoginActivity : AppCompatActivity() {
    private lateinit var a: User
    private lateinit var b: User
    private lateinit var c: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener(clickListener)

        a = User(
            getString(R.string.login_a),
            getString(R.string.password_a),
            "vk.com"
        )
        b = User(
            getString(R.string.login_b),
            getString(R.string.password_b),
            "google.com"
        )
        c = User(
            getString(R.string.login_c),
            getString(R.string.password_c),
            "yandex.ru"
        )

    }

    private val clickListener = View.OnClickListener {
        val emailText = findViewById<EditText>(R.id.username)
        val passwordText = findViewById<EditText>(R.id.password)

        val email = emailText.text.toString()
        val pass = passwordText.text.toString().hashCode()


        if (a.username == email && a.password == pass) {
            setWebSite(a.url,a.username)
        }
        else if (b.username == email && b.password == pass) {
            setWebSite(b.url,b.username)
        }
        else if (c.username == email && c.password == pass) {
            setWebSite(c.url,c.username)
        }
        else
        {
            Toast.makeText(
                applicationContext,
                getString(R.string.login_failed),
                Toast.LENGTH_LONG
            ).show()
        }
    }


    private fun setWebSite(site: String, name: String)
    {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(WEB_SITE,site)
            putExtra(USERNAME,name)
        }
        startActivity(intent)
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.container)

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            constraintLayout.setBackgroundResource(R.drawable.back_landscape)
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            constraintLayout.setBackgroundResource(R.drawable.back_portrait)
        }
    }
}
