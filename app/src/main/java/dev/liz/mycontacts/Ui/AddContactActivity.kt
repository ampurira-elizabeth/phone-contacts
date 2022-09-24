package dev.liz.mycontacts.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dev.liz.mycontacts.Model.Contacts
import dev.liz.mycontacts.R
import dev.liz.mycontacts.ViewModel.ContactsViewModel
import dev.liz.mycontacts.databinding.ActivityAddContactBinding
import dev.liz.mycontacts.databinding.ActivityViewContactBinding

class AddContactActivity : AppCompatActivity() {
     lateinit var binding: ActivityAddContactBinding
     val ContactsViewModel:ContactsViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSaveContact.setOnClickListener { validateAddContact() }
    }
    fun validateAddContact(){
        var name= binding.etName.text.toString()
        var email= binding.etEmail.text.toString()
        var phoneNumber= binding.etPhoneNum.text.toString()
        var address= binding.etAddress.text.toString()
        //validate this
    val contact= Contacts(contactId = 0,
        name=name,
        phoneNumber=phoneNumber,
        email=email,
        address=address,
        image = "")
        ContactsViewModel.savedContact(contact)
        finish()
    }
    //display contacts in db
}