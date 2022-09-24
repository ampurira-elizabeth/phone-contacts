package dev.liz.mycontacts.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.liz.mycontacts.Model.Contacts
import dev.liz.mycontacts.Repository.ContactsRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactsViewModel:ViewModel() {
    val contactsRepository=ContactsRepository()
    fun savedContact(contacts: Contacts){
        viewModelScope.launch {
            contactsRepository.saveContact(contacts)
        }

    }
}