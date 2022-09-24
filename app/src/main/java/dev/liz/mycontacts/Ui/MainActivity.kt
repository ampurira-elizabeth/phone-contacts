package dev.liz.mycontacts.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.liz.mycontacts.Model.Contacts
import dev.liz.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()

    }

    override fun onResume() {
        super.onResume()
        binding.fabAddContact.setOnClickListener {
            startActivity(Intent(this,AddContactActivity::class.java))
        }
    }
    fun displayContacts(){
        var contact1= Contacts(1,"Lizie","0780434451","lizbarisi@gmail.com","616 kampala","https://images.unsplash.com/photo-1589156280159-27698a70f29e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact2= Contacts(2,"Aggie","0780834471","aggiebarisi@gmail.com","kampala","https://images.unsplash.com/photo-1519419691348-3b3433c4c20e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGJsYWNrJTIwcGVvcGxlJTIwaW4lMjBsb3ZlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact3= Contacts(3,"Raxie","07804389451","raxiebarisi@gmail.com","16 kampala","https://images.unsplash.com/photo-1583994009785-37ec30bf9342?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact4= Contacts(4,"Dathan","0780634451","dathanbarisi@gmail.com"," kampala","https://images.unsplash.com/photo-1523450001312-faa4e2e37f0f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact5= Contacts(5,"Hillz","0780004451","hillzbarisi@gmail.com","606 kampala","https://images.unsplash.com/photo-1531384441138-2736e62e0919?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTN8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contactsList= listOf(contact1,contact2,contact3,contact4,contact5)
        var contactsAdapter= contactsRvAdapter(contactsList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }


}