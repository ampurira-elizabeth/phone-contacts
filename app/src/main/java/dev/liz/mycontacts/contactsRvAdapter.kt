package dev.liz.mycontacts

import android.content.ReceiverCallNotAllowedException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.liz.mycontacts.databinding.ContactListItemBinding

class contactsRvAdapter(var contactList:List<Contacts>):RecyclerView.Adapter<contactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        var binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var contactViewHolder=contactViewHolder(binding)
        return contactViewHolder
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        var currentcontact=contactList.get(position)
        holder.binding.tvName.text=currentcontact.name
        holder.binding.tvEmail.text=currentcontact.email
        holder.binding.tvLocate.text=currentcontact.address
        holder.binding.tvPhone.text=currentcontact.phoneNumber
        Picasso.get().load(currentcontact.image).error(R.drawable.ic_baseline_error_outline_24)
            .placeholder(R.drawable.ic_baseline_person_24)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .resize(300,300).centerCrop()
            .into(holder.binding.igContact)
    }

    override fun getItemCount(): Int {
       return contactList.size
    }
}
class contactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root)


