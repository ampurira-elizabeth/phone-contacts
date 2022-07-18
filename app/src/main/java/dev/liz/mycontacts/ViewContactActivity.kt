package dev.liz.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.liz.mycontacts.databinding.ActivityMainBinding
import dev.liz.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
   lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityViewContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
        val extras=intent.extras
        val name=extras?.getString("NAME","")
        val phone=extras?.getString("NUMBER","")
        var image3= binding.ivperson

        Toast.makeText(this, name,Toast.LENGTH_LONG).show()
        Toast.makeText(this, phone,Toast.LENGTH_LONG).show()
        binding.tvName2.text=name
        binding.tvPhone2.text=phone
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image3)

    }
}