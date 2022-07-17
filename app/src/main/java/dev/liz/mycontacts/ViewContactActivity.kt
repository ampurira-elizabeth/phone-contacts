package dev.liz.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ViewContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)
        getExtras()
    }
    fun getExtras(){
        val extras=intent.extras
        val name=extras?.getString("NAME","")
        val email=extras?.getString("EMAIL","")
        val address=extras?.getString("ADDRESS","")
        val phone=extras?.getString("NUMBER","")
        val image=extras?.getString("IMAGE","")
        Toast.makeText(this,"$name : $email : $address : $phone : $image",Toast.LENGTH_LONG).show()
    }
}