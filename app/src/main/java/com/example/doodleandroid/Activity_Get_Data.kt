package com.example.doodleandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.parcelize.Parcelize
import java.io.Serializable

class Activity_Get_Data : AppCompatActivity() {
    private lateinit var etEmail: TextView
    private lateinit var etPassword: TextView
    private lateinit var backBtn: Button
    private lateinit var list:ArrayList<UserData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)

        etEmail=findViewById(R.id.txt_pass_email)

        etPassword=findViewById(R.id.txt_pass_password)
        backBtn=findViewById(R.id.back_btn)


        val strGetEmail=intent.getStringExtra("email")
        val strGetPassword=intent.extras?.getStringArrayList("demoList")
        etEmail.setText(strGetEmail)
        etPassword.setText(strGetPassword.toString())
        backBtn.setOnClickListener {
            val passData=Intent(this,MainActivity::class.java)

//            print("Kkkk"+list.toString())
            passData.putExtra("dataObj",UserData(etEmail.text.toString(),etPassword.text.toString()))
         //   passData.putExtra("password","Yess")
           // startActivity(passData)
            println(UserData(etEmail.text.toString(),etPassword.text.toString()))
setResult(RESULT_OK,passData)
            finish();
        }


    }

}

data class UserData(var email: String, var password: String,):Serializable