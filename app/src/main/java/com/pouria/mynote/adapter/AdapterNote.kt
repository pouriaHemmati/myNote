package com.pouria.note.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pouria.note.R
import com.pouria.note.model.NoteModel

class AdapterNote(val context: Context, var mData: List<NoteModel>, var listener: Listeners) : RecyclerView.Adapter<AdapterNote.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_note, viewGroup, false)

        return ViewHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val a = mData[i]

        holder.tvTitle.text = a.title
        holder.tvDesc.text = a.description
        holder.layout.setOnClickListener {
            listener.onClicked(a)
        }

        val currentNightMode: Int = context.resources
            .configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {
                Log.i("Mode" , "UI_MODE_NIGHT_NO")
                holder.layout.setBackgroundColor(context.getColor(R.color.snackBarColor))
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                Log.i("Mode" , "UI_MODE_NIGHT_YES")
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    interface Listeners {
        fun onClicked(note: NoteModel)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.txt_title)
        var tvDesc: TextView = itemView.findViewById(R.id.txt_desc)
        var layout: CardView = itemView.findViewById(R.id.layout)
    }
}