package dev.liz.mycontacts.Repository

import dev.liz.mycontacts.Database.ContactsDB
import dev.liz.mycontacts.Model.Contacts
import dev.liz.mycontacts.MyContacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class ContactsRepository {
    val database=ContactsDB.getDatabase(MyContacts.appContext)

    suspend fun saveContact(contacts: Contacts){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contacts)
        }
    }
}