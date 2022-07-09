package dev.liz.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import dev.liz.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()

    }
    fun displayContacts(){
        var contact1=Contacts("Lizie","0780434451","lizbarisi@gmail.com","616 kampala","")
        var contact2=Contacts("Aggie","0780834471","aggiebarisi@gmail.com","kampala","")
        var contact3=Contacts("Raxie","07804389451","raxiebarisi@gmail.com","16 kampala","")
        var contact4=Contacts("Dathan","0780634451","dathanbarisi@gmail.com"," kampala","")
        var contact5=Contacts("Hillz","0780004451","hillzbarisi@gmail.com","606 kampala","")
        var contactsList= listOf(contact1,contact2,contact3,contact4,contact5)
        var contactsAdapter=contactsRvAdapter(contactsList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }


}