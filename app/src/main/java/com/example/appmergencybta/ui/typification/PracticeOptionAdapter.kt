package com.example.appmergencybta.ui.typification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R

/**
 * Adaptador para las opciones de práctica
 */
class PracticeOptionAdapter(
    private val context: Context,
    private val onOptionClick: (Int) -> Unit
) : RecyclerView.Adapter<PracticeOptionAdapter.OptionViewHolder>() {

    private var options: List<String> = emptyList()
    private var selectedPosition = -1
    private var correctPosition = -1
    private var showFeedback = false

    fun setOptions(options: List<String>, correctPosition: Int) {
        this.options = options
        this.correctPosition = correctPosition
        this.selectedPosition = -1
        this.showFeedback = false
        notifyDataSetChanged()
    }

    fun setShowFeedback(show: Boolean) {
        this.showFeedback = show
        notifyDataSetChanged()
    }

    fun getSelectedPosition(): Int = selectedPosition

    fun isCorrectSelected(): Boolean = selectedPosition == correctPosition

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_practice_option, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val option = options[position]
        holder.bind(option, position)
    }

    override fun getItemCount(): Int = options.size

    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvOptionText: TextView = itemView.findViewById(R.id.tvOptionText)
        private val layoutOption: ConstraintLayout = itemView.findViewById(R.id.layoutOption)
        private val cardView: CardView = itemView as CardView

        fun bind(option: String, position: Int) {
            tvOptionText.text = option

            // Configurar el color de fondo según la selección y si es correcta
            if (showFeedback) {
                when {
                    position == correctPosition -> {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light))
                    }
                    position == selectedPosition && selectedPosition != correctPosition -> {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
                    }
                    else -> {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
                    }
                }
            } else {
                if (position == selectedPosition) {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.purple_500))
                    tvOptionText.setTextColor(ContextCompat.getColor(context, android.R.color.white))
                } else {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
                    tvOptionText.setTextColor(ContextCompat.getColor(context, android.R.color.black))
                }
            }

            // Configurar el click listener
            layoutOption.setOnClickListener {
                if (!showFeedback) {
                    val oldSelectedPosition = selectedPosition
                    selectedPosition = position
                    notifyItemChanged(oldSelectedPosition)
                    notifyItemChanged(selectedPosition)
                    onOptionClick(position)
                }
            }
        }
    }
}
