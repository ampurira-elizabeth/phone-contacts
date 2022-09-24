package dev.liz.mycontacts.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity( tableName = "Contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true) var contactId: Int,
    var name:String,
    var phoneNumber:String,
    var email:String,
    var address:String,
    var image:String
)
