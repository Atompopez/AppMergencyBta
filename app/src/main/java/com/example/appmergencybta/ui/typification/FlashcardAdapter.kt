package com.example.appmergencybta.ui.typification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R
import com.example.appmergencybta.data.database.entities.TypificationCode

/**
 * Adaptador para las tarjetas de memorización de códigos
 */
class FlashcardAdapter(
    private val context: Context,
    private val onFlashcardClicked: (TypificationCode) -> Unit
) : RecyclerView.Adapter<FlashcardAdapter.FlashcardViewHolder>() {

    private var codes: List<TypificationCode> = emptyList()
    private var showingFront = true

    inner class FlashcardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardFlashcard: CardView = itemView.findViewById(R.id.cardFlashcard)
        val tvFlashcardFront: TextView = itemView.findViewById(R.id.tvFlashcardFront)
        val tvFlashcardBack: TextView = itemView.findViewById(R.id.tvFlashcardBack)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_flashcard, parent, false)
        return FlashcardViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        val code = codes[position]
        
        // Configurar el contenido de la tarjeta
        holder.tvFlashcardFront.text = code.code
        holder.tvFlashcardBack.text = code.acronym
        
        // Mostrar el lado correcto de la tarjeta
        holder.tvFlashcardFront.visibility = if (showingFront) View.VISIBLE else View.GONE
        holder.tvFlashcardBack.visibility = if (showingFront) View.GONE else View.VISIBLE
        
        // Configurar el color de fondo según el tipo de código
        val backgroundColorId = getBackgroundColorForCode(code.code)
        holder.cardFlashcard.setCardBackgroundColor(ContextCompat.getColor(context, backgroundColorId))
        
        // Configurar el click en la tarjeta
        holder.cardFlashcard.setOnClickListener {
            onFlashcardClicked(code)
        }
    }

    override fun getItemCount(): Int = codes.size

    /**
     * Establece la lista de códigos para mostrar
     */
    fun setCodes(codes: List<TypificationCode>) {
        this.codes = codes
        notifyDataSetChanged()
    }

    /**
     * Cambia entre mostrar el código o el acrónimo
     */
    fun flipCards() {
        showingFront = !showingFront
        notifyDataSetChanged()
    }

    /**
     * Obtiene un color de fondo según el tipo de código
     */
    private fun getBackgroundColorForCode(code: String): Int {
        // Asignar colores según el primer dígito del código (categoría)
        return when {
            code.startsWith("1") -> R.color.flashcard_security
            code.startsWith("2") -> R.color.flashcard_medical
            code.startsWith("3") -> R.color.flashcard_disaster
            code.startsWith("4") -> R.color.flashcard_traffic
            code.startsWith("5") -> R.color.flashcard_environment
            code.startsWith("6") -> R.color.flashcard_public_services
            code.startsWith("7") -> R.color.flashcard_social
            code.startsWith("8") -> R.color.flashcard_infrastructure
            code.startsWith("9") -> R.color.flashcard_other
            else -> R.color.white
        }
    }
}
