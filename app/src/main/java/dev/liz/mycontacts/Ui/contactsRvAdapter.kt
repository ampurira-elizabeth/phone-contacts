package dev.liz.mycontacts.Ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.liz.mycontacts.Model.Contacts
import dev.liz.mycontacts.R
import dev.liz.mycontacts.databinding.ContactListItemBinding

class contactsRvAdapter(var contactList:List<Contacts>):RecyclerView.Adapter<contactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        var binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var contactViewHolder= contactViewHolder(binding)
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

        var context=holder.itemView.context
        holder.binding.igContact.setOnClickListener {
            Toast.makeText(context,"you have clicked on ${currentcontact.name}'s image",Toast.LENGTH_SHORT).show()
        }

        holder.binding.cvContact.setOnClickListener {
            var intent=Intent(context, ViewContactActivity::class.java)
            intent.putExtra("NAME",currentcontact.name)
            intent.putExtra("EMAIL",currentcontact.email)
            intent.putExtra("ADDRESS",currentcontact.address)
            intent.putExtra("NUMBER",currentcontact.phoneNumber)
            intent.putExtra("IMAGE",currentcontact.image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return contactList.size
    }
}
class contactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root)


