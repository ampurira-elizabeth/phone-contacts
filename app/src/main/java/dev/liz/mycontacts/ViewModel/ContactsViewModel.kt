package dev.liz.mycontacts.ViewModel

import android.view.contentcapture.ContentCaptureSession
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.liz.mycontacts.Model.Contacts
import dev.liz.mycontacts.Repository.ContactsRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactsViewModel:ViewModel() {
    val contactsRepository=ContactsRepository()
    lateinit var contactLIveData:LiveData<Contacts>

    fun savedContact(contacts: Contacts){
        viewModelScope.launch {
            contactsRepository.saveContact(contacts)
        }

    }

    fun fetchContactsById(contactId:Int){
        contactLIveData=contactsRepository.getContactById(contactId)
    }
}