package com.example.appmergencybta.ui.typification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R
import com.example.appmergencybta.data.database.entities.TypificationCode

/**
 * Adaptador para la lista de códigos de tipificación
 */
class TypificationCodeAdapter(
    private val context: Context,
    private val onItemClick: (TypificationCode) -> Unit
) : RecyclerView.Adapter<TypificationCodeAdapter.CodeViewHolder>() {

    private var codes: List<TypificationCode> = emptyList()

    fun setCodes(codes: List<TypificationCode>) {
        this.codes = codes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CodeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_typification_code, parent, false)
        return CodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CodeViewHolder, position: Int) {
        val code = codes[position]
        holder.bind(code)
    }

    override fun getItemCount(): Int = codes.size

    inner class CodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivCodeIcon: ImageView = itemView.findViewById(R.id.ivCodeIcon)
        private val tvCodeNumber: TextView = itemView.findViewById(R.id.tvCodeNumber)
        private val tvCodeAcronym: TextView = itemView.findViewById(R.id.tvCodeAcronym)
        private val tvCodeDescription: TextView = itemView.findViewById(R.id.tvCodeDescription)
        private val btnViewDetails: Button = itemView.findViewById(R.id.btnViewDetails)

        fun bind(code: TypificationCode) {
            // Establecer el icono según el recurso de imagen
            val resourceId = getDrawableResourceId(code.imageResource)
            if (resourceId != 0) {
                ivCodeIcon.setImageResource(resourceId)
            } else {
                ivCodeIcon.setImageResource(R.drawable.ic_emergency)
            }

            // Establecer los textos
            tvCodeNumber.text = context.getString(R.string.code_number, code.code)
            tvCodeAcronym.text = context.getString(R.string.code_acronym, code.acronym)
            tvCodeDescription.text = code.description

            // Configurar el botón de detalles
            btnViewDetails.setOnClickListener {
                onItemClick(code)
            }

            // Hacer que todo el elemento sea clickeable
            itemView.setOnClickListener {
                onItemClick(code)
            }
        }

        private fun getDrawableResourceId(resourceName: String?): Int {
            if (resourceName.isNullOrEmpty()) return 0
            return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
        }
    }
}
