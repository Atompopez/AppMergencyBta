package com.example.appmergencybta.ui.typification

import android.animation.ValueAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
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
        private val cardView: CardView = itemView.findViewById(R.id.cardOption)

        fun bind(option: String, position: Int) {
            tvOptionText.text = option

            // Configurar el estado de selección
            layoutOption.isSelected = position == selectedPosition
            
            // Configurar colores y estilos según el estado
            if (showFeedback) {
                when {
                    position == correctPosition -> {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.correct_option))
                        tvOptionText.setTextColor(ContextCompat.getColor(context, R.color.text_white))
                        tvOptionText.textSize = 18f
                        tvOptionText.setTypeface(tvOptionText.typeface, android.graphics.Typeface.BOLD)
                    }
                    position == selectedPosition && selectedPosition != correctPosition -> {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.incorrect_option))
                        tvOptionText.setTextColor(ContextCompat.getColor(context, R.color.text_white))
                        tvOptionText.textSize = 18f
                    }
                    else -> {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.unselected_option))
                        tvOptionText.setTextColor(ContextCompat.getColor(context, R.color.primary_dark_blue))
                        tvOptionText.textSize = 16f
                        tvOptionText.setTypeface(tvOptionText.typeface, android.graphics.Typeface.NORMAL)
                    }
                }
            } else {
                if (position == selectedPosition) {
                    // Aplicar animación de selección
                    animateSelection(cardView)
                    
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.selected_option))
                    tvOptionText.setTextColor(ContextCompat.getColor(context, R.color.primary_dark_blue))
                    tvOptionText.textSize = 18f
                    tvOptionText.setTypeface(tvOptionText.typeface, android.graphics.Typeface.BOLD)
                    
                    // Aumentar la elevación para dar efecto de selección
                    cardView.cardElevation = 8f
                } else {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.unselected_option))
                    tvOptionText.setTextColor(ContextCompat.getColor(context, R.color.primary_dark_blue))
                    tvOptionText.textSize = 16f
                    tvOptionText.setTypeface(tvOptionText.typeface, android.graphics.Typeface.NORMAL)
                    
                    // Restaurar elevación normal
                    cardView.cardElevation = 3f
                }
            }

            // Configurar el click listener para toda la tarjeta
            cardView.setOnClickListener {
                if (!showFeedback) {
                    val oldSelectedPosition = selectedPosition
                    selectedPosition = position
                    notifyItemChanged(oldSelectedPosition)
                    notifyItemChanged(selectedPosition)
                    onOptionClick(position)
                }
            }
        }
        
        // Función para animar la selección de una opción
        private fun animateSelection(cardView: CardView) {
            // Animar la escala
            val scaleAnimator = ValueAnimator.ofFloat(1f, 1.05f, 1f)
            scaleAnimator.duration = 300
            scaleAnimator.interpolator = AccelerateDecelerateInterpolator()
            scaleAnimator.addUpdateListener { animator ->
                val scale = animator.animatedValue as Float
                cardView.scaleX = scale
                cardView.scaleY = scale
            }
            scaleAnimator.start()
        }
    }
}
