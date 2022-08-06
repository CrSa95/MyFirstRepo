package com.example.myfirstapp

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection
import java.sql.DriverManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = findViewById<EditText>(R.id.User)
        val pass = findViewById<EditText>(R.id.Pass)
        val send = findViewById<Button>(R.id.Send)
    }
    fun connectionDB(): Connection? {
        var cnn: Connection? = null
        try {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.62;databaseName=usuarios;user=root;password=123456;")
        } catch (e: Exception) {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_SHORT).show()
        }
        return cnn
    }
}