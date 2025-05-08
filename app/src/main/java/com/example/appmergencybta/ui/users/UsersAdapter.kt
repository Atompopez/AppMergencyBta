package com.example.appmergencybta.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R
import com.example.appmergencybta.data.model.User

class UsersAdapter(
    private val onUserAction: (User, UserAction) -> Unit
) : ListAdapter<User, UsersAdapter.UserViewHolder>(UserDiffCallback()) {

    enum class UserAction {
        TOGGLE_ACTIVE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user, onUserAction)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvUserName)
        private val tvDocument: TextView = itemView.findViewById(R.id.tvUserDocument)
        private val tvEntity: TextView = itemView.findViewById(R.id.tvUserEntity)
        private val tvRole: TextView = itemView.findViewById(R.id.tvUserRole)
        private val btnToggleActive: Button = itemView.findViewById(R.id.btnToggleActive)

        fun bind(user: User, onUserAction: (User, UserAction) -> Unit) {
            tvName.text = user.displayName
            tvDocument.text = "Documento: ${user.documentNumber}"
            tvEntity.text = "Entidad: ${user.entity}"
            tvRole.text = "Rol: ${user.role}"

            // Configurar el botón según el estado del usuario
            if (user.isActive) {
                btnToggleActive.text = "Desactivar"
                btnToggleActive.setBackgroundResource(R.drawable.button_red)
            } else {
                btnToggleActive.text = "Activar"
                btnToggleActive.setBackgroundResource(R.drawable.button_green)
            }

            btnToggleActive.setOnClickListener {
                onUserAction(user, UserAction.TOGGLE_ACTIVE)
            }
        }
    }

    class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}
