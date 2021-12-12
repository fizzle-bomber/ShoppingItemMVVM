package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent , false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]
        holder.nameTextView.text = curShoppingItem.name
        holder.amountTextView.text = curShoppingItem.amount.toString()
        holder.ivdelete.setOnClickListener{
            viewModel.delete(curShoppingItem)
        }
        holder.ivplus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.insert(curShoppingItem)
        }
        holder.ivminus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.insert(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val nameTextView = itemView.findViewById<TextView>(R.id.tvName)
        val amountTextView = itemView.findViewById<TextView>(R.id.tvAmount)
        val ivdelete = itemView.findViewById<ImageView>(R.id.ivDelete)
        val ivminus = itemView.findViewById<ImageView>(R.id.ivMinus)
        val ivplus = itemView.findViewById<ImageView>(R.id.ivPlus)
    }
}