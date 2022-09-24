package dev.liz.mycontacts.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.liz.mycontacts.Model.Contacts

@Database(entities = arrayOf(Contacts::class), version = 1)
 abstract class ContactsDB: RoomDatabase() {
     abstract fun contactDao(): ContactsDao

     companion object{
         private var database:ContactsDB?=null

         fun getDatabase(context: Context):ContactsDB{
             if (database==null){
                 database= Room.databaseBuilder(context,ContactsDB::class.java,"ContactsDB")
                     .fallbackToDestructiveMigration().build()
//
             }
             return database as ContactsDB
         }
     }


}