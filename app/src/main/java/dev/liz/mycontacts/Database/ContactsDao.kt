package dev.liz.mycontacts.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.liz.mycontacts.Model.Contacts


@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contacts: Contacts)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contacts>>

    @Query("SELECT * FROM contacts WHERE contactId=:contactId")
    fun getContactById(contactId:Int):LiveData<Contacts>

}