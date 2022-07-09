package dev.liz.mycontacts

import android.content.ReceiverCallNotAllowedException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class contactsRvAdapter(var contactList:List<Contacts>):RecyclerView.Adapter<contactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
      var itemView=LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return contactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        var currentcontact=contactList.get(position)
        holder.tvName.text=currentcontact.name
        holder.tvEmail.text=currentcontact.email
        holder.tvLocate.text=currentcontact.address
        holder.tvPhone.text=currentcontact.phoneNumber
    }

    override fun getItemCount(): Int {
       return contactList.size
    }
}
class contactViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvPhone=itemView.findViewById<TextView>(R.id.tvPhone)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvLocate=itemView.findViewById<TextView>(R.id.tvLocate)
    var igContact=itemView.findViewById<ImageView>(R.id.igContact)
}