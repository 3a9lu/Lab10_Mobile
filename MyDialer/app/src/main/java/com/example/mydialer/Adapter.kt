package com.example.mydialer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Adapter : ListAdapter<Contact, ViewHolder>(ContactItemDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rview_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = currentList[position]
        holder.bindTo(data)
    }
}
class ContactDiffUtil(private val old: List<Contact>, private val new: List<Contact>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}

class ContactItemDiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Contact, newItem: Contact) = oldItem == newItem
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textview1: TextView = view.findViewById(R.id.textView)
    private val textview2: TextView = view.findViewById(R.id.textView2)
    private val textview3: TextView = view.findViewById(R.id.textView3)

    fun bindTo(contact: Contact){
        if (textview1 != null) {
            textview1.text = contact.name
        }
        if (textview2 != null) {
            textview2.text = contact.phone
        }
        if (textview3 != null) {
            textview3.text = contact.type
        }

    }
}